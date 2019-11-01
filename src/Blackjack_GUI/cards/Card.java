package Blackjack_GUI.cards;

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

    public void print() {
        String pVal;
        if (value == CardValue.JACK) pVal = "J ";
        else if (value == CardValue.QUEEN) pVal = "Q ";
        else if (value == CardValue.KING) pVal = "K ";
        else if (value == CardValue.ACE) pVal = "A ";
        else if (value == CardValue.TEN) pVal = "" + value.getPoints();
        else pVal = value.getPoints() + " ";
//        pVal = "A";
        String symbol = suit.getSymbol() + " ";
        System.out.println("┌─────────┐");
        System.out.println("│" + pVal + "       │");
        System.out.println("│         │");
        System.out.println("│         │");
        System.out.println("│    " + symbol + "   │");
        System.out.println("│         │");
        System.out.println("│         │");
        System.out.println("│       " + pVal + "│");
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
        return (value + " OF " + suit.getSymbol());
    }
}
