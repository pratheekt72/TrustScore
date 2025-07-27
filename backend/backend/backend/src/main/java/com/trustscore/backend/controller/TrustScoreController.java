package com.trustscore.backend.controller;

import com.trustscore.backend.model.User;
import com.trustscore.backend.service.TrustScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class TrustScoreController
{
    @Autowired
    private TrustScoreService trustscore;

    @PostMapping("/trustscore")
    public User getTrustScore(@RequestBody UserIdRequest request)
    {
        return trustscore.getUserById(request.getUserid());
    }

    

    public static class UserIdRequest
    {
        private String userid;
        
        public String getUserid()
        {
            return userid;
        }

        public void setUserId(String userid)
        {
            this.userid = userid;

        }
    }
}