package com.alekseysamoylov.learn;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alekseysamoylov.learn.entity.Card;
import com.alekseysamoylov.learn.entity.User;
import com.alekseysamoylov.learn.repository.UserRepository;
import com.alekseysamoylov.learn.service.UserService;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
