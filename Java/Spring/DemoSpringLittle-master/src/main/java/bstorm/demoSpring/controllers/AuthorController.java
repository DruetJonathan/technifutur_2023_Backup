package bstorm.demoSpring.controllers;

import bstorm.demoSpring.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<?> get(@RequestParam String keyword) {
        return ResponseEntity.ok(authorService.getByKeyword(keyword));
    }
}
