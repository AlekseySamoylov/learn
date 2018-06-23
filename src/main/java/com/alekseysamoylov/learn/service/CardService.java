package com.alekseysamoylov.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alekseysamoylov.learn.entity.Card;
import com.alekseysamoylov.learn.repository.CardRepository;

@Service
@Transactional
public class CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private UserService userService;

    public List<Card> saveOne(Card card) {
        if (userService.isUserExist(card.getCardOwner())) {
            cardRepository.save(card);
            return cardRepository.findAll();
        } else {
            throw new IllegalArgumentException("Card has incorrect user");
        }
    }

    public List<Card> deleteOne(Card card) {
        cardRepository.delete(card);
        return cardRepository.findAll();
    }

    public void testMethodForJmx(String message) {
        System.out.println("Hello JMX " + message);
    }

    @Transactional(readOnly = true)
    public List<Card> findAll() {
        return cardRepository.findAll();
    }
}
