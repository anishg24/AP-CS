package Blackjack.players;

import Blackjack.cards.*;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand = new ArrayList<>();
    private Deck deck;
    private int num_won;
    private int points;
    private boolean stay;

    public Player(Deck deck){
        num_won = 0;
        points = 0;
        stay = false;
        this.deck = deck;
        draw();
        calculate_points();
    }

    private void calculate_points() {
        points = 0;
        for(Card card : hand){
//            System.out.println("card.getValue().getPoints() = " + card.getValue().getPoints());
            points += card.getValue().getPoints();
        }
    }

    private void draw(){
        for (int i = 0; i < 2; i++) {
            Card card = deck.getRandomCard();
            hand.add(card);
            deck.getDeck().remove(card);
        }
    }

    public void hit(Deck deck){
        Card card = deck.getRandomCard();
        hand.add(card);
        deck.getDeck().remove(card);
        calculate_points();
    }

    public List<Card> getHand() {
        return hand;
    }

    public Deck getDeck() {
        return deck;
    }

    public int getPoints() {
        return points;
    }

    public int getWon() {
        return num_won;
    }

    public void incrementWin(){
        num_won++;
    }

    public boolean isStay() {
        return stay;
    }

    public void setStay(boolean stay) {
        this.stay = stay;
    }
}
