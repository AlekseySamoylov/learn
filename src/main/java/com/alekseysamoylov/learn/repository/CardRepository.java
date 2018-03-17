package com.alekseysamoylov.learn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alekseysamoylov.learn.entity.Card;

public interface CardRepository extends MongoRepository<Card, String> {
}
