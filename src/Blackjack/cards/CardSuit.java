package Blackjack.cards;

public enum CardSuit {
    HEARTS("♥"), CLUBS("♣"), DIAMONDS("♦"), SPADES("♠");

    private String symbol;

    CardSuit(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
