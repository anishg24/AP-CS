package Blackjack;

import Blackjack.cards.*;
import Blackjack.players.*;

import java.util.List;

public class Blackjack_Runner
{
	public static void run()	// Runs the game
	{

		Deck deck = new Deck();
		Player player = new Player(deck);
		for (int i = 0; i< 10; i++){
			player.hit();
			System.out.println(player.getDeck().getDeck());
		}
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
