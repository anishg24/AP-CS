package Blackjack;

import Blackjack.cards.*;
import Blackjack.players.*;

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
		Player player = new Player(deck);
		Player dealer = new Player(player.getDeck());

		// Less typing later on
		int playerPoints = player.getPoints();
		int dealerPoints = dealer.getPoints();

		// Initial prints
		printHands(player, dealer);

		boolean condition1 = (dealerPoints < 21 && playerPoints < 21);
		boolean condition2 = (!player.isStay() && !dealer.isStay());
		boolean condition3;

		while((dealerPoints < 21 && playerPoints < 21) && (!player.isStay() || !dealer.isStay())){

			if (!player.isStay()) {
				System.out.println("Want to hit? (yes/no)");
				continuePlay = input.next().compareToIgnoreCase("yes") == 0;
			}

			if(continuePlay){
				player.hit(dealer.getDeck());
			} else player.setStay(true);

			if (dealerPoints <= 16) {
				dealer.setStay(false);
				dealer.hit(player.getDeck());
			}
			else dealer.setStay(true);

			playerPoints = player.getPoints();
			dealerPoints = dealer.getPoints();

			printHands(player, dealer);
			System.out.println();
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
		} else if (playerPoints == dealerPoints){		// a tie: dealer wins
			System.out.println("DEALER WINS!");
		} else {										// no one busts
			System.out.println("NO ONE BUSTS!");
		}

	}

	public static void printHands(Player player, Player dealer){
		System.out.println("PLAYER: " + player.getHand() + " = " + player.getPoints());
//		System.out.println("\tPLAYER STAYING? " + player.isStay());
		System.out.println("DEALER: " + dealer.getHand() + " = " + dealer.getPoints());
//		System.out.println("\tDEALER STAYING? " + dealer.isStay());
	}

	public static boolean chooseToHit(Player player){
		Scanner read = new Scanner(System.in);
		System.out.println("Would you like to hit? ");
		boolean result;

		if (read.next().compareToIgnoreCase("yes") == 0) result = false;
		else result = true;

		player.setStay(result);

//		System.out.println("result = " + result);

		return result;
	}
	
	public static void main(String[] args)
	{
//		System.out.println("Welcome to Mr. Lee's Blackjack Casino!");
//		System.out.println("Would you like to play Blackjack against me?");
//
//		Scanner read = new Scanner(System.in);
//
//		String run = read.next();		// Reads next input as a String
//		boolean game_on = false;
//
//
//		if (run.compareToIgnoreCase("yes") == 0)		// checks to see if the the user's input is yes or YES or YeS or yES
//		{
//			game_on = true;
//			run();
//		}

		run();
		
		

	}

}
