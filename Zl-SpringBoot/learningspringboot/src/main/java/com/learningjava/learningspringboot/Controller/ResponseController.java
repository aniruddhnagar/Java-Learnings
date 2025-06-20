package com.learningjava.learningspringboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("request")
@RequestMapping("/response")
public class ResponseController {

    @Autowired
    private User3 user3;

    @Autowired
    private Order3 order3;

    // Call: http://localhost:8090/response/fetchUser?firstName=RUDDH
    @GetMapping("/fetchUser")
    public ResponseEntity<String> getUser(@RequestParam (name = "firstName") String firstName) {

        System.out.println("Order3 initialized: " + order3.hashCode());
        String output = "User details: " + firstName;
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }
}
