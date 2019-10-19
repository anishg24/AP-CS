package Blackjack.cards;

public enum CardValue {

    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10),
    QUEEN(10), KING(10), ACE(0);

    private int points;

    CardValue(int points) {
        this.points = points;
    }

    public int getPoints() {
        int chance;

        if (points == 0){
            chance = (int)(2*Math.random());

            if (chance == 0) points = 1;
            else points = 11;
        }

        return points;
    }
}
