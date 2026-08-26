package com.canpepfrit.apicanpepfrit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApicanpepfritApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApicanpepfritApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("API iniciada correctamente");
    }
}
