package Blackjack.cards;

public class Card {
    CardSuit suit;
    CardValue value;

    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public CardSuit getSuit() {
        return suit;
    }

//    public void setSuit(CardSuit suit) {
//        this.suit = suit;
//    }

    public CardValue getValue() {
        return value;
    }

//    public void setValue(CardValue value) {
//        this.value = value;
//    }

//    public void print(){
//
//        "┌─────────┐"+
//        "│{}       │"+
//        "│         │"+
//        "│         │"+
//        "│    {}   │"+
//        "│         │"+
//        "│         │"+
//        "│       {}│"+
//        "└─────────┘"
//
//    }

    @Override
    public String toString() {
        return (this.value + " " + this.suit);
    }
}
