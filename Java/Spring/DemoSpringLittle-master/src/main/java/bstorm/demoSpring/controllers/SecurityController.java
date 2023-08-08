package bstorm.demoSpring.controllers;

import bstorm.demoSpring.dto.LoginDTO;
import bstorm.demoSpring.dto.TokenDTO;
import bstorm.demoSpring.utils.JwtUtils;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class SecurityController {

    private final JwtUtils jwtUtils;

    public SecurityController(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO dto) {
        if(dto.getPassword().equals("test1234") && dto.getUsername().equals("admin")) {
            String token = jwtUtils.createToken(1L, "Admin", "admin");
            return ResponseEntity.ok(new TokenDTO(token, "Admin", "admin", 1L));
        }

        if(dto.getPassword().equals("test1234") && dto.getUsername().equals("customer")) {
            String token = jwtUtils.createToken(2L, "Customer", "customer");
            return ResponseEntity.ok(new TokenDTO(token, "Customer", "customer", 2L));
        }

        return  ResponseEntity.badRequest().body("Invalid credentials");
    }
}
