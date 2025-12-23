
package com.example.vulnapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VulnAppApplication {
    public static void main(String[] args) {

        // Arguments passed below are user controlled and makes this line potentially vulnerable to some time of an injection vulnerability
        SpringApplication.run(VulnAppApplication.class, args);
    }
}
