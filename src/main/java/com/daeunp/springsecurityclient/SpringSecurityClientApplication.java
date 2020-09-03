package com.daeunp.springsecurityclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.daeunp.springsecurityclient")
public class SpringSecurityClientApplication {
    public static void main(String[] args) {
    	SpringApplication.run(SpringSecurityClientApplication.class, args);
    }
}
