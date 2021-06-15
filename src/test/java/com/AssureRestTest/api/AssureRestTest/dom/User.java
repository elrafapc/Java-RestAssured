package com.AssureRestTest.api.AssureRestTest.dom;

import org.junit.jupiter.api.BeforeEach;

public class User {
    private String name;
    private String job;
    private String email;

    public User(){}

    public User(String name, String job, String email) {
        this.name = name;
        this.job = job;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {this.email = email;}
}
