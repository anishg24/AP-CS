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

    public void replay(){
        hand.clear();
        stay = false;
        draw();
        calculate_points();
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

    private String[] getCardValues(){
        String[] result = new String[hand.size()];
        for(int i = 0; i < hand.size(); i++){
            CardValue value = hand.get(i).getValue();

            if (value == CardValue.JACK) result[i] = "J ";
            else if (value == CardValue.QUEEN) result[i] = "Q ";
            else if (value == CardValue.KING) result[i] = "K ";
            else if (value == CardValue.ACE) result[i] = "A ";
            else if (value == CardValue.TEN) result[i] = "" + value.getPoints();
            else result[i] = value.getPoints() + " ";
        }
        return result;
    }

    private String[] getCardSuits(){
        String[] result = new String[hand.size()];
        for (int i = 0; i < hand.size() ; i++){
            CardSuit symbol = hand.get(i).getSuit();
            result[i] = symbol.getSymbol() + " ";
        }
        return result;
    }

    public void printHand(){
        String[] values = getCardValues();
        String[] suits = getCardSuits();

            String top_card = "┌─────────┐";
//            String top_value = "│" + pVal + "       │";
            String card_body = "│         │";
//            String symbol_card = "│    " + symbol + "   │";
//            String bottom_value = "│       " + pVal + "│";
            String bottom_card = "└─────────┘";

        // Card top
        for (int i = 0; i < hand.size(); i++) System.out.print(top_card);
        System.out.println();

        // Heading value
        for (int i = 0; i < hand.size(); i++){
            String pVal = values[i];
            String top_value = "│" + pVal + "       │";
            System.out.print(top_value);
        }
        System.out.println();

        // Card body
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < hand.size(); j++) {
                System.out.print(card_body);
            }
            System.out.println();
        }

        // Symbol
        for (int i = 0; i < hand.size(); i++){
            String symbol = suits[i];
            String symbol_card = "│    " + symbol + "   │";
            System.out.print(symbol_card);
        }
        System.out.println();

        // Card body
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < hand.size(); j++) {
                System.out.print(card_body);
            }
            System.out.println();
        }

        // Bottom value
        for (int i = 0; i < hand.size(); i++){
            String pVal = values[i];
            String bottom_value = "│       " + pVal + "│";
            System.out.print(bottom_value);
        }
        System.out.println();

        // Bottom card
        for(int i = 0; i < hand.size(); i++) System.out.print(bottom_card);
        System.out.println();


//            System.out.println("┌─────────┐");
//            System.out.println("│" + pVal + "       │");
//            System.out.println("│         │");
//            System.out.println("│         │");
//            System.out.println("│    " + symbol + "   │");
//            System.out.println("│         │");
//            System.out.println("│         │");
//            System.out.println("│       " + pVal + "│");
//            System.out.println("└─────────┘");

    }

    public void printHiddenHand(){
        String[] values = getCardValues();
        String[] suits = getCardSuits();

        String pVal = values[0];
        String symbol = suits[0];

        String top_card = "┌─────────┐";
        String top_value = "│" + pVal + "       │";
        String card_body = "│         │";
        String symbol_card = "│    " + symbol + "   │";
        String bottom_value = "│       " + pVal + "│";
        String bottom_card = "└─────────┘";

        String hidden_value_top = "│ ??      │";
        String hidden_symbol = "│    ?    │";
        String hidden_value_bot = "│      ?? │";

        System.out.println(top_card + top_card);
        System.out.println(top_value + hidden_value_top);
        System.out.println(card_body + card_body);
        System.out.println(card_body + card_body);
        System.out.println(symbol_card + hidden_symbol);
        System.out.println(card_body + card_body);
        System.out.println(card_body + card_body);
        System.out.println(bottom_value + hidden_value_bot);
        System.out.println(bottom_card + bottom_card);
    }

}
