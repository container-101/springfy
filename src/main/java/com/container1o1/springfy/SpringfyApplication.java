package com.container1o1.springfy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// Todo: enable spring security
@SpringBootApplication()
public class SpringfyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringfyApplication.class, args);
    }

}
