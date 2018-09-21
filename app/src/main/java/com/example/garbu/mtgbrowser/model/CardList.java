package com.example.garbu.mtgbrowser.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by garbu on 9/3/2018.
 */

public class CardList{

    @SerializedName("cards")
    @Expose
    private List<Card> cards = null;

    public CardList() {
        //empty constructor
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

}
