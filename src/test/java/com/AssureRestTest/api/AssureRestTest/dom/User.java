package com.AssureRestTest.api.AssureRestTest.dom;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonAlias("first_name")
    private String name;
    private String job;
    private String email;
    @JsonAlias("last_name")
    private String lastName;


    public User(){}

    public User(String name, String job, String email) {
        this.name = name;
        this.job = job;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}

    public String getJob() {
        return job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {this.email = email;}

    public void setJob(String job) { this.job = job; }

    public String getLastName() { return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}
}
