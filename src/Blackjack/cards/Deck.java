package Blackjack.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Deck {

    List<Card> deck = new ArrayList<>();

    public Deck() {
        Arrays.stream(CardSuit.values()).forEach(cardSuit -> {
            Family myFamily = new Family(cardSuit);
            deck.addAll(myFamily.getCards());
        });
    }

    public List<Card> getDeck() {
        return deck;
    }

    public Card getRandomCard() {
        int index = new Random().nextInt(deck.size());
        return deck.get(index);
    }

}

