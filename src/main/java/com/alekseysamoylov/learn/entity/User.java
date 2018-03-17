package com.alekseysamoylov.learn.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Accessors(chain = true)
@Document(collection = "user")
public class User {

    @Id
    private String name;
}
