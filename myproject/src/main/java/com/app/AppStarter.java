package com.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class AppStarter {

    public static void main(String[] args) {
        SpringApplication.run(AppStarter.class);
    }
}
