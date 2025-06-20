package com.learningjava.learningspringboot.Controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

// One instance per IOC, eagerly created at the time of startup only.
@Scope("singleton")
public class Order {

    public Order() {
        System.out.println("Order initialized: " + this.hashCode());
    }
}
