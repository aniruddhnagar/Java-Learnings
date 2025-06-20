package com.learningjava.learningspringboot.Controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class User2 {

    private String username;
    private String email;

    @Autowired
    private Order order;

    @Autowired
    private Order2 order2;

    // Constructor now uses @Value to inject values from properties
    public User2(@Value("${user.username}") String name, @Value("${user.email}") String mailId) {
        this.username = name;
        this.email = mailId;
        System.out.println("User2 initialized: " + this.hashCode());
    }

    @PostConstruct
    public void initialize() {
        System.out.println("It is post construct2.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("It is pre destroy2.");
        // Fail fast - fail at compilation itself rather than failing at run time.
        System.out.println(order == null);
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
