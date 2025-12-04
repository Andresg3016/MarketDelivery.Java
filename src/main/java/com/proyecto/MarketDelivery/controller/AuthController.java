package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.dto.*;
import com.proyecto.MarketDelivery.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    public AuthController(AuthService authService) { this.authService = authService; }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest req){
        String token = authService.register(req);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req){
        String token = authService.login(req);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
