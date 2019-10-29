package Blackjack;

import Blackjack.cards.*;
import Blackjack.players.*;
import Blackjack.scanner.*;
import Blackjack.scanner.scanners.menu.*;

import java.util.List;
import java.util.Scanner;

public class Blackjack_Runner
{
    public static void run()	// Runs the game
    {
        // Setup the game
        // Create a deck, the player classes
        Scanner input = new Scanner(System.in);
        boolean continuePlay = true;
        Deck deck = new Deck();
        Player dealer = new Player("DEALER",deck);              // THIS ORDERING OF INITIALIZATION AND DECLARATION IS IMPORTANT
        Player player = new Player("PLAYER",dealer.getDeck());

        // Less typing later on
        int playerPoints = player.getPoints();
        int dealerPoints = dealer.getPoints();

        // Initial prints
        printInitialHands(player, dealer);

        while((dealerPoints < 21 && playerPoints < 21) && !player.isStay()){

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

        if (playerPoints > 21 && dealerPoints > 21){    // player and dealer are both out of bounds: higher points is loser
            if (playerPoints > dealerPoints){
                System.out.println("DEALER WINS!");
            } else {
                System.out.println("PLAYER WINS!");
            }
        } else if (playerPoints > 21){					// player has more than 21: automatic loss
            System.out.println("YOU BUST!");
        } else if (dealerPoints > 21) {					// dealer has more than 21: automatic win
            System.out.println("DEALER BUST!");
        } else if (playerPoints == 21){					// player hits 21: immediate win
            System.out.println("YOU GOT 21!");
        } else if (dealerPoints == 21){					// dealer hits 21: immediate loss
            System.out.println("DEALER GOT 21!");
        } else if (playerPoints == dealerPoints || 21 - playerPoints > 21 - dealerPoints ){		// yeeet
            System.out.println("DEALER WINS!");
        } else if (21 - playerPoints < 21 - dealerPoints) {										// idk
            System.out.println("PLAYER WINS!");
        }

    }

    public static void printInitialHands(Player player, Player dealer){
        printHand(player);
        System.out.println(dealer.getName() + ": [" + dealer.getHand().get(0) +", " + " ??? OF ???]" + " = ???");
    }

    public static void printHands(Player player, Player dealer){
        printHand(player);
        printHand(dealer);
    }

    public static void printHand(Player person){
        System.out.println(person.getName() + ": " + person.getHand() + " = " + person.getPoints());
    }


    public static boolean chooseToHit(){
        boolean result = false;
        // Define some options for the menu
        String[] options = {"Hit", "Stand"};

        // Create a new prompt attached to standard input/output
        Prompt prompt = new Prompt(System.in, System.out);

        // Instantiate a menu scanner
        MenuInputScanner scanner = new MenuInputScanner(options);

        // Setup the menu prompt message
        scanner.setMessage("Are you going to hit or stand? ");

        // Grab the user in a loop until a valid input is inserted
//        int userInput = prompt.getUserInput(scanner);

        if (prompt.getUserInput(scanner) == 1) result = true;

        return result;
    }

    public static void main(String[] args)
    {
		System.out.println("Welcome to Mr. Lee's Blackjack Casino!");
		System.out.println("Would you like to play Blackjack against me?");

		Scanner read = new Scanner(System.in);

		String run = read.next();		// Reads next input as a String


		if (run.compareToIgnoreCase("yes") == 0)		// checks to see if the the user's input is yes or YES or YeS or yES
		{
			run();
		} else {
            System.out.println("Why did you even run me then?");
            System.exit(69696969);
        }


    }

}