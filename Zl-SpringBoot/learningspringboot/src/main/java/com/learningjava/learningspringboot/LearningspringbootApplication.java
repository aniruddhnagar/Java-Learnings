package com.learningjava.learningspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// To make it scan for beans to this and its chils package heirarchy
@ComponentScan(basePackages = "com.learningjava.learningspringboot")
public class LearningspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LearningspringbootApplication.class, args);
//		context.close();
	}

}
