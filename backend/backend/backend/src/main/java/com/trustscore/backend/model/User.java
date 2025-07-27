package com.trustscore.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")  
public class User {

    @Id
    private String id; 

    private String userid; 
    private String name;
    private String email;
    private int creditScore;
    private double trustScore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditscore) {
        this.creditScore = creditscore;
    }

    public double getTrustScore() {
        return trustScore;
    }

    public void setTrustScore(double trustscore) {
        this.trustScore = trustscore;
    }
}
