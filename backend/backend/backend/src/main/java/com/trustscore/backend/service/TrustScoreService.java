package com.trustscore.backend.service;

import com.trustscore.backend.model.User;
import org.springframework.stereotype.Service;

@Service
public class TrustScoreService
{
    public User getUserById(String userid)
    {
        User user = new User();
        user.setId(userid);
        user.settrustscore(700);
        return user;
    }
}