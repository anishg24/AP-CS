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

    public void print(){
        String A = "A ";
        System.out.println("┌─────────┐");
        System.out.println("│"+A+"        │");
        System.out.println("│         │");
        System.out.println("│         │");
        System.out.println("│    {}   │");
        System.out.println("│         │");
        System.out.println("│         │");
        System.out.println("│       {}│");
        System.out.println("└─────────┘");
    }

    @Override
    public String toString() {
//        String A = "A ";
//        return(
//
//                        "┌─────────┐\n"+
//                        "│"+A+"       │\n"+
//                        "│         │\n"+
//                        "│         │\n"+
//                        "│    {}   │\n"+
//                        "│         │\n"+
//                        "│         │\n"+
//                        "│       {}│\n"+
//                        "└─────────┘\n"
//        );
        return (value + " OF " + suit);
    }
}
