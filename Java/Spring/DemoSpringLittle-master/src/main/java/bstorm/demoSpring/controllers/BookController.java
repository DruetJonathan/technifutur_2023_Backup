package bstorm.demoSpring.controllers;


import bstorm.demoSpring.dto.BookAddDTO;
import bstorm.demoSpring.dto.BookSimpleDTO;
import bstorm.demoSpring.exceptions.NotFoundException;
import bstorm.demoSpring.exceptions.UniqueException;
import bstorm.demoSpring.services.BookService;
import bstorm.demoSpring.utils.FileUtils;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService service;
    private final FileUtils fileUtils;

    public BookController(BookService service, FileUtils fileUtils) {
        this.service = service;
        this.fileUtils = fileUtils;
    }

    @GetMapping("/hello")
    public ResponseEntity<?> Hello() {
        return ResponseEntity.ok(service.getHello());
    }

    @GetMapping
    @ApiResponse(content = @Content(array = @ArraySchema(schema = @Schema(implementation = BookSimpleDTO.class))))
    public ResponseEntity<?> getAll(@RequestParam int page) {
        return ResponseEntity.ok(service.getAll(PageRequest.of(page-1, 10)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    @PreAuthorize("hasAuthority('Admin')")
    @ApiResponse(content = @Content(schema = @Schema(implementation = BookSimpleDTO.class)))
    public ResponseEntity<?> post(@Valid @RequestBody BookAddDTO dto) {
        try {
            return ResponseEntity.ok(service.add(dto));
        } catch (UniqueException e) {
            return ResponseEntity.badRequest().body("Cet isbn existe déjà");
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("L'image n'a pas pu être sauvegardée.");
        }
    }

    @GetMapping("/images/{imageName}")
    public ResponseEntity getImage(@PathVariable("imageName") String imageName) {
        try {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                    .body(new InputStreamResource(fileUtils.get(imageName)));
        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
