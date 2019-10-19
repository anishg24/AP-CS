package Blackjack.players;

import Blackjack.cards.*;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand = new ArrayList<>();
    private Deck deck;
    private int points;
    private int num_won;

    public Player(Deck deck){
        this.deck = deck;
        draw();
    }

    private void draw(){
        for (int i = 0; i < 2; i++) {
            Card card = deck.getRandomCard();
            hand.add(card);
            deck.getDeck().remove(card);
        }
    }

    public void hit(){
        Card card = deck.getRandomCard();
        hand.add(card);
        deck.getDeck().remove(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public Deck getDeck() {
        return deck;
    }
}
