package com.container1o1.springfy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// Enable JPA Auditing
@EnableJpaAuditing
@SpringBootApplication()
public class SpringfyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringfyApplication.class, args);
    }

}
