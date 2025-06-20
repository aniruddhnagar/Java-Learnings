package com.learningjava.learningspringboot.Controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

// Each time new instance created, lazily created at the time of requirement.
@Scope("prototype")
public class Order2 {

    public Order2() {
        System.out.println("Order2 initialized: " + this.hashCode());
    }
}
