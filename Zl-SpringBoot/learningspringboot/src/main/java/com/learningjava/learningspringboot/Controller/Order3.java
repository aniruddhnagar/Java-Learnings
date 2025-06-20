package com.learningjava.learningspringboot.Controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

// For each HTTP: new instance created, lazily at the time of requirement.
@Scope("request")

//New instance for each HTTP session , Lazily initialized,
// When user access any endpoint, session is created and remains active till it does not expire.
//@Scope("session")

public class Order3 {

    public Order3() {
        System.out.println("Order3 initialized: " + this.hashCode());
    }
}
