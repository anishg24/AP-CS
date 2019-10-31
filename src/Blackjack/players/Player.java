package Blackjack.players;

import Blackjack.cards.*;
import Blackjack.scanner.Prompt;
import Blackjack.scanner.scanners.precisiondouble.DoubleInputScanner;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand = new ArrayList<>();
    private Deck deck;
    private int num_won;
    private int points;
    private boolean stay;
    private String name;
    private double balance;

    public Player(String name, Deck deck, double balance) {
        this.name = name;
        num_won = 0;
        points = 0;
        stay = false;
        this.balance = balance;
        this.deck = deck;
        draw();
        calculate_points();
    }

    private void calculate_points() {
        points = 0;
        for (Card card : hand) {
//            System.out.println("card.getValue().getPoints() = " + card.getValue().getPoints());
            points += card.getValue().getPoints();
        }
    }

    private void draw() {
        for (int i = 0; i < 2; i++) {
            Card card = deck.getRandomCard();
            hand.add(card);
            deck.getDeck().remove(card);
        }
    }

    public void hit(Deck deck) {
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

    public void incrementWin() { num_won++; }

    public boolean isStay() {
        return stay;
    }

    public void setStay(boolean stay) {
        this.stay = stay;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void addBalance(double amount){
        this.balance += amount;
    }

    public void subtractBalance(double amount){
        this.balance -= amount;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double bet(){
        System.out.println("You have " + balance + "$!");
        Prompt prompt = new Prompt(System.in, System.out);
        DoubleInputScanner scanner = new DoubleInputScanner();
        scanner.setMessage("How much do you want to bet? ");

        double userInput = prompt.getUserInput(scanner);
        while(balance < userInput){
            if (userInput < 10) System.out.println("You have to bet at least 10$!");
            else System.out.println("You don't have enough money to bet that! (You have " + balance + "$!)");
            userInput = prompt.getUserInput(scanner);
        }

        if (balance > userInput) balance -= userInput;
        return userInput;
    }
}
