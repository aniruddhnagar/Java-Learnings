package com.learningjava.learningspringboot.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/body")
public class BodyController {

    @PostMapping(path = "/saveUser")
    public String getUserDetails(@RequestBody User user) {
        return "User details: " + user.username + " : " + user.email;
    }
}
