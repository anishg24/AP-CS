package Blackjack.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Family {

    List<Card> cards = new ArrayList<>();

    public Family(CardSuit suit) {
        Arrays.stream(CardValue.values()).forEach(cardValue -> {
            cards.add(new Card(suit, cardValue));
        });
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card getRandomCard() {
        int index = new Random().nextInt(cards.size());
        return cards.get(index);
    }

}

