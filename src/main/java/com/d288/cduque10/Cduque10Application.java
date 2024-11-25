package com.d288.cduque10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories
public class Cduque10Application {

    public static void main(String[] args) {
        SpringApplication.run(Cduque10Application.class, args);
    }

}
