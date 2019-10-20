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
		Deck deck = new Deck();
		Player player = new Player(deck);
		Player dealer = new Player(player.getDeck());

		// Less typing later on
		int playerPoints = player.getPoints();
		int dealerPoints = dealer.getPoints();

		// Initial prints
		printHands(player, dealer);

		while((playerPoints < 21 && dealer.getPoints() < 21) || (player.isStay() && dealer.isStay())){
			if (!player.isStay()) {
				boolean choice = chooseToHit(player);
				System.out.println("player.isStay() = " + player.isStay());
				player.hit(dealer.getDeck());
			}

			if (dealerPoints <= 16) dealer.setStay(false);
			else dealer.setStay(true);

			if (!dealer.isStay()) {
				dealer.hit(player.getDeck());
			}

			playerPoints = player.getPoints();
			dealerPoints = dealer.getPoints();

			printHands(player, dealer);
		}


		if(playerPoints > 21 && dealerPoints <= 21){
			System.out.println("YOU BUST!");
		} else if ((dealerPoints > 21 && playerPoints < 21) || playerPoints == 21) {
			System.out.println("DEALER BUST!");
		} else {
			System.out.println("NO ONE BUSTED");
		}

	}

	public static void printHands(Player player, Player dealer){
		System.out.println("PLAYER: " + player.getHand() + " = " + player.getPoints());
		System.out.println("DEALER: " + dealer.getHand() + " = " + dealer.getPoints());
	}

	public static boolean chooseToHit(Player player){
		Scanner read = new Scanner(System.in);
		System.out.println("Would you like to hit? ");
		boolean result;

		if (read.next().compareToIgnoreCase("yes") == 0) result = false;
		else result = true;

		player.setStay(result);

		System.out.println("result = " + result);

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
