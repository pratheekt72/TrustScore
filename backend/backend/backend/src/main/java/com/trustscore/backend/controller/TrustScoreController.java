package com.trustscore.backend.controller;

import com.trustscore.backend.model.User;
import com.trustscore.backend.service.TrustScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TrustScoreController {

    @Autowired
    private TrustScoreService trustscore;

    // 🔍 Public: fetch trust score by userid
    @PostMapping("/trustscore")
    public User getTrustScore(@RequestBody UserIdRequest request) {
        return trustscore.getUserById(request.getUserid());
    }

    // 🟢 Public: simple placeholder for application submission
    @PostMapping("/apply")
    public ResponseEntity<String> submitApplication(@RequestBody ApplicationRequest request) {
        // ✅ Just accept the request and echo it back
        return ResponseEntity.ok("Application submitted successfully by user: " + request.getUserid());
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
        private String additionalInfo; // optional

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

