package com.alekseysamoylov.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alekseysamoylov.learn.entity.Card;
import com.alekseysamoylov.learn.service.CardService;

@CrossOrigin
@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Card> allCards() {
        return cardService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Card> saveCard(@RequestBody Card card) {
        return cardService.saveOne(card);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public List<Card> deleteCard(@RequestBody Card card) {
        return cardService.deleteOne(card);
    }

}
