package com.alekseysamoylov.learn.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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

    public String getPhrase() {
        return phrase;
    }

    public Card setPhrase(String phrase) {
        this.phrase = phrase;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public Card setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public User getCardOwner() {
        return cardOwner;
    }

    public Card setCardOwner(User cardOwner) {
        this.cardOwner = cardOwner;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return new EqualsBuilder().append(this.phrase, card.phrase).build();
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder().append(phrase).build();
    }
}
