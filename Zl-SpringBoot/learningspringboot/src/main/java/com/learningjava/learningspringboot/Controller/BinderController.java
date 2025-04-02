package com.learningjava.learningspringboot.Controller;

import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/binder")
public class BinderController {

    @InitBinder
    protected void initBinder(DataBinder binder) {
        binder.registerCustomEditor(String.class, "firstName", new FirstNamePropertyEditor());
        binder.registerCustomEditor(String.class, "lastName", new FirstNamePropertyEditor());
    }

    // Call: http://localhost:8090/binder/fetchUser?firstName=RUDDH&lastName=Nagar&age=30
    @GetMapping("/fetchUser")
    public String getUser(@RequestParam(name = "firstName", required = true) String firstName,
                          @RequestParam (name = "lastName") String lastName,
                          @RequestParam (name = "age") String age) {

        return "User details: " + firstName + " " + lastName + " - " + age;
    }
}

