package com.learningjava.learningspringboot.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/response")
public class ResponseController {

    // Call: http://localhost:8090/response/fetchUser?firstName=RUDDH
    @GetMapping("/fetchUser")
    public ResponseEntity<String> getUser(@RequestParam (name = "firstName") String firstName) {

        String output = "User details: " + firstName;
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }
}
