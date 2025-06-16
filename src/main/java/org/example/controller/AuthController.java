package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.dto.AuthRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/auth")
@Tag(name = "Authentication API", description = "Operations for user authentication")
public interface AuthController {
    @PostMapping("/authenticate")
    @Operation(summary = "Authenticate user by username and password")
    ResponseEntity<String> authenticate(@RequestBody AuthRequest authRequest);
}
