package com.learningjava.learningspringboot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/params")
public class ParamsController {

    // Call: http://localhost:8090/params/fetchUser1?firstName=Ruddh&age=30
    // Call: http://localhost:8090/params/fetchUser1?firstName=Ruddh&lastName=Nagar&age=30
    @GetMapping("/fetchUser1")
    public String getUser(@RequestParam (name = "firstName", required = true) String firstName,
                          @RequestParam (name = "lastName") String lastName,
                          @RequestParam (name = "age") String age) {

        return "User details: " + firstName + " " + lastName + " - " + age;
    }

    // Call: http://localhost:8090/params/fetchUser2/Ruddh/30
    @GetMapping("/fetchUser2/{name}/{age}")
    public String getUser2(@PathVariable (value = "name") String firstName,
                          @PathVariable (value = "age") Integer age) {

        return "User2 details: " + firstName + " " + age;
    }
}
