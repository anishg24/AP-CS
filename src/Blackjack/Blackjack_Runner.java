package Blackjack;

import Blackjack.cards.*;
import Blackjack.players.*;
import Blackjack.scanner.*;
import Blackjack.scanner.scanners.menu.*;
import Blackjack.scanner.scanners.precisiondouble.DoubleInputScanner;

import java.util.List;
import java.util.Scanner;

public class Blackjack_Runner {
    public static Player[] run(Player player, Player dealer)    // Runs the game
    {
        // Setup the game
        // Create a deck, the player classes
//        Deck deck = new Deck();
//        Player dealer = new Player("DEALER", deck, Double.POSITIVE_INFINITY);              // THIS ORDERING OF INITIALIZATION AND DECLARATION IS IMPORTANT
//        Player player = new Player("PLAYER", dealer.getDeck(), 1000);

        double player_bet = player.bet();

        // Less typing later on
        int playerPoints = player.getPoints();
        int dealerPoints = dealer.getPoints();

        // Initial prints
        printInitialHands(player, dealer);

        while ((dealerPoints < 21 && playerPoints < 21) && !player.isStay()) {

//            if (!player.isStay()) {
//                System.out.println("Want to hit? (yes/no)");
//                continuePlay = input.next().compareToIgnoreCase("yes") == 0;
//            }
//
//            if(continuePlay){
//                player.hit(dealer.getDeck());
//            } else player.setStay(true);
//
//            if (dealerPoints <= 16) {
//                dealer.setStay(false);
//                dealer.hit(player.getDeck());
//            }
//            else dealer.setStay(true);
            if (!player.isStay()) {
                if (chooseToHit()) {
                    player.hit(player.getDeck());
                    printHand(player);
                } else {
                    player.setStay(true);
                }
            }

            playerPoints = player.getPoints();
            dealerPoints = dealer.getPoints();

//            printHand(player);
        }

        System.out.println();
        dealer.setDeck(player.getDeck());
        printHands(player, dealer);

        while (dealerPoints <= 16) {
            dealer.hit(dealer.getDeck());
            dealerPoints = dealer.getPoints();
            printHand(dealer);
        }

        // Logic Handling, determine who wins the game

        if (playerPoints > 21 && dealerPoints > 21) {    // player and dealer are both out of bounds: higher points is loser
            if (playerPoints > dealerPoints) {
                handleWin(dealer, false);
                handleBet(dealer,player,player_bet);
            } else {
                handleWin(player, false);
                handleBet(player,dealer,player_bet);
            }
        } else if (playerPoints > 21) {                    // player has more than 21: automatic loss
            handleWin(dealer, false);
            handleBet(dealer,player,player_bet);
        } else if (dealerPoints > 21) {                    // dealer has more than 21: automatic win
            handleWin(player, false);
            handleBet(player,dealer,player_bet);
        } else if (playerPoints == 21) {                    // player hits 21: immediate win
            handleWin(player, true);
            handleBet(player,dealer,player_bet);
        } else if (dealerPoints == 21) {                    // dealer hits 21: immediate loss
            handleWin(dealer, true);
            handleBet(dealer,player,player_bet);
        } else if (playerPoints == dealerPoints || 21 - playerPoints > 21 - dealerPoints) {        // yeeet
            handleWin(dealer, false);
            handleBet(dealer,player,player_bet);
        } else if (21 - playerPoints < 21 - dealerPoints) {                                        // idk
            handleWin(player, false);
            handleBet(player,dealer,player_bet);
        }
        return new Player[]{player,dealer};
    }

    public static void printInitialHands(Player player, Player dealer) {
        printHand(player);
        System.out.println(dealer.getName().toUpperCase() + ": (??)");
        dealer.printHiddenHand();
    }

    public static void printHands(Player player, Player dealer) {
        printHand(player);
        printHand(dealer);
    }

    public static void printHand(Player person) {
        System.out.println(person.getName().toUpperCase() + ": (" + person.getPoints()+")");
        person.printHand();
    }

    public static void handleWin(Player person, boolean got_21) {
        person.incrementWin();
        String mod = " WINS!";
        if (got_21) mod = " GOT 21!";
        System.out.println(person.getName() + mod);
    }

    public static void handleBet(Player winner, Player loser, double bet){
        bet *= 1.5;
        winner.addBalance(bet);
        loser.subtractBalance(bet);
    }

    public static boolean chooseToHit() {
        boolean result = false;
        // Define some options for the menu
        String[] options = {"Hit", "Stand"};

        // Create a new prompt attached to standard input/output
        Prompt prompt = new Prompt(System.in, System.out);

        // Instantiate a menu scanner
        MenuInputScanner scanner = new MenuInputScanner(options);

        // Setup the menu prompt message
        scanner.setMessage("Are you going to hit or stand? ");
        scanner.setError("Please enter either 1 or 2!");

        // Grab the user in a loop until a valid input is inserted

        if (prompt.getUserInput(scanner) == 1) result = true;

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Mr. Lee's Blackjack Casino!");
        System.out.println("Would you like to play Blackjack against me?");

        Scanner read = new Scanner(System.in);

        String run = read.next();        // Reads next input as a String



        if (run.compareToIgnoreCase("yes") == 0)        // checks to see if the the user's input is yes or YES or YeS or yES
        {
            Deck deck = new Deck();
            Player dealer = new Player("DEALER", deck, Double.POSITIVE_INFINITY);              // THIS ORDERING OF INITIALIZATION AND DECLARATION IS IMPORTANT
            Player player = new Player("PLAYER", dealer.getDeck(), 1000);
            Player[] array = run(player,dealer);
            player = array[0];
            dealer = array[1];
            if (player.getBalance() < 0 || dealer.getBalance() < 0) {
                System.out.println("You don't have any more money!");
                System.exit(6969);
            }
            System.out.println("Would you like to play again? (yes/no)");
            while(read.next().compareToIgnoreCase("yes") == 0){
                player.replay();
                dealer.replay();
                run(player,dealer);
            }
        } else {
            System.out.println("Why did you even run me then?");
            System.exit(69);
        }
    }

}