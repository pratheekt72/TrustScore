package com.trustscore.backend.controller;

import com.trustscore.backend.model.User;
import com.trustscore.backend.service.TrustScoreService;
import com.trustscore.backend.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TrustScoreController {

    @Autowired
    private TrustScoreService trustscore;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    // 🔍 Public: fetch trust score by userid
    @PostMapping("/trustscore")
    public User getTrustScore(@RequestBody UserIdRequest request) {
        return trustscore.getUserById(request.getUserid());
    }

    // 🔐 Protected: apply with JWT token
    @PostMapping("/apply")
    public ResponseEntity<String> submitApplication(
            @RequestHeader("Authorization") String authHeader,
            @RequestBody ApplicationRequest request) {

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body("Missing or invalid Authorization header");
        }

        String token = authHeader.replace("Bearer ", "");
        String username;

        try {
            username = jwtTokenUtil.getUsernameFromToken(token);
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid or expired token");
        }

        // ✅ Token is valid; process application logic
        return ResponseEntity.ok("Application submitted successfully by user: " + username);
    }

    // 📦 Request body for /trustscore
    public static class UserIdRequest {
        private String userid;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }
    }

    // 📦 Request body for /apply
    public static class ApplicationRequest {
        private String userid;
        private String additionalInfo; // optional — adapt as needed

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getAdditionalInfo() {
            return additionalInfo;
        }

        public void setAdditionalInfo(String additionalInfo) {
            this.additionalInfo = additionalInfo;
        }
    }
}
