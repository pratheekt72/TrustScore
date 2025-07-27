package com.trustscore.backend.service;

import com.trustscore.backend.model.User;
import com.trustscore.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrustScoreService {

    @Autowired
    private UserRepository userRepository;

    
    public User getUserById(String userid) 
    {
        System.out.println("Looking for user with userid: " + userid); 
        return userRepository.findByUserid(userid).orElse(null);
    }


}
