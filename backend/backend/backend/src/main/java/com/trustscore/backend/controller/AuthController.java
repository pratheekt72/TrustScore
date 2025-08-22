package com.trustscore.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        return ResponseEntity.ok("User '" + username + "' registered successfully (demo mode)");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String fakeToken = "demo-token-for-" + username;

        return ResponseEntity.ok(Map.of("token", fakeToken));
    }
}
