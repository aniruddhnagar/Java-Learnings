package com.learningjava.learningspringboot.config;

import com.learningjava.learningspringboot.Controller.Order3;
import com.learningjava.learningspringboot.Controller.User2;
import com.learningjava.learningspringboot.Controller.User3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Marks this as a Spring configuration class
public class AppConfiguration {

    @Bean
    public User2 createUserBean2() {
        // Manually create an User2 bean and pass hardcoded values or values from properties
        return new User2("Nagar", "nagar@gmail.com");
    }

    @Bean
    public User3 createUserBean3() {
        // Manually create an User2 bean and pass hardcoded values or values from properties
        return new User3("Nagar", "nagar@gmail.com");
    }

    @Bean
    public Order3 Order3() {
        return new Order3();
    }

}
