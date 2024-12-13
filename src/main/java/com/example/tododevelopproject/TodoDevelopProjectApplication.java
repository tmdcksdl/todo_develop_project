package com.example.tododevelopproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TodoDevelopProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoDevelopProjectApplication.class, args);
    }

}
