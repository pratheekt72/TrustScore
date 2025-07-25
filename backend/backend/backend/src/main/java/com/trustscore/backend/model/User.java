package com.trustscore.backend.model;


public class User
{
    private String id;
    private String name;
    private String email;
    private int creditscore;
    private double trustscore;


    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setname(String name)
    {
        this.name = name;
    }

    public String getemail()
    {
        return email;
    }

    public void setemail(String email)
    {
        this.email = email;
    }

    public int getCreditScore()
    {
        return creditscore;
    }

    public void setcreditscore(int creditscore)
    {
        this.creditscore = creditscore;
    }

    public double getTrustScore()
    {
        return trustscore;
    }

    public void settrustscore(double trustscore)
    {
        this.trustscore = trustscore;
    }
}