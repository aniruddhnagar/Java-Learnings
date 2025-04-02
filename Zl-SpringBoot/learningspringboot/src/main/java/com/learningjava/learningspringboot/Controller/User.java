package com.learningjava.learningspringboot.Controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("user_name")
    String username;
    String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
