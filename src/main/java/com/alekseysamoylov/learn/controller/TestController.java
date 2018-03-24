package com.alekseysamoylov.learn.controller;

import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alekseysamoylov.learn.entity.Card;
import com.alekseysamoylov.learn.entity.User;
import com.alekseysamoylov.learn.service.CardService;
import com.alekseysamoylov.learn.service.UserService;

@ApiIgnore
@RestController
public class TestController {

    @Autowired
    private CardService cardService;
    @Autowired
    private UserService userService;

    @RequestMapping("/saveUser")
    public List<User> saveUser() {
        var randomNumber = ThreadLocalRandom.current().nextInt();
        var user = new User().setName("Username" + randomNumber);
        userService.save(user);
        return userService.findAll();
    }

    @RequestMapping("/saveCard")
    public List<Card> saveCard() {
        int randomNumber = ThreadLocalRandom.current().nextInt();
        Card card = new Card()
                .setPhrase("Random phrase" + randomNumber)
                .setTranslation("Рандомная фраза" + randomNumber)
                .setCardOwner(userService.findAll().iterator().next());
        cardService.saveOne(card);
        return cardService.findAll();
    }
}
