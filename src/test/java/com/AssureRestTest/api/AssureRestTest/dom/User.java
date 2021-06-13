package com.AssureRestTest.api.AssureRestTest.dom;

import org.junit.jupiter.api.BeforeEach;

public class User {
    private String name;
    private String job;

    public User(){}

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
