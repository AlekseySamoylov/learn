package com.alekseysamoylov.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alekseysamoylov.learn.entity.User;
import com.alekseysamoylov.learn.service.CardService;
import com.alekseysamoylov.learn.service.UserService;

@RestController
@RequestMapping("/")
public class WelcomeController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        List<User> users = userService.findAll();
        return "Hello Docker World" + users;
    }
}
