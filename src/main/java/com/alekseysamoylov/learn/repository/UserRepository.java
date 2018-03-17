package com.alekseysamoylov.learn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alekseysamoylov.learn.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByName(String name);
}
