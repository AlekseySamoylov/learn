package com.alekseysamoylov.learn.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Accessors(chain = true)
@Document(collection = "card")
public class Card {

    @Id
    private String phrase;

    private String translation;

    private User cardOwner;
}
