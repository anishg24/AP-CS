import java.util.Scanner;

public class While_Loop
{

	public static void main(String[] args) 
	{
		// This is how we call methods. We will talk about how methods work more in future labs.

//		Example_1(); // This calls the method, called "Example_1()".
//		Example_2();
//		Example_3();
//		Example_4();
//		Example_5();
		Collatz_Sequence();
	}

	static void Example_2() // Main will jump and find the method Example_1() first.
	{

		System.out.println("Example 2:");
		// We will look at the syntax of a while loop

		int money_made = 90;
		int lemonade_sold = 0;
		int lemonade_cost = 3;
		
		// The first iteration of the while loop
		while (money_made < 1000)
		{
			lemonade_sold++;
			money_made += lemonade_sold*lemonade_cost;
		}
		// After finishing the while loop, it returns to the main method
	}

	static void Example_1()		// Main will call this method first. Order written does not matter.
	{
		System.out.println("Example 1:");

		int count = 1;
		int sum = 0;

		while (count <= 100)
		{
			sum += count;
			count++;
		}
		System.out.println("The sum is: " + sum);
	}

	static void Example_3()
	{
		System.out.println("Example 3:");
		Scanner read = new Scanner(System.in);

		// Math.random() creates a random number of type double between 0 and 1.
		// This random number can include 0, but cannot include 1...      0 <= x < 1
		int secret_number = (int)(20*Math.random());

		System.out.println("Take a \"whiled\" guess.");
		// The backslash, '\', breaks the quotation mark to use at as a literal character.
		int guess = read.nextInt();

		// !!!!!!!!!!DO NOT RUN UNTIL YOU HAVE READ THE WHILE LOOP!!!!!!!!!
		while (guess != secret_number)
		{
			// Type in a statement that tells the user that it is incorrect and asks to try again.
				System.out.println("You're wrong fool! Try again");
				guess = read.nextInt();
		}
		System.out.println("Congratulations. You got the number correct.");

	}
	static void Example_4()
	{

		System.out.println("Example 4:");

		// This program is intended to print positive numbers from 0 to 30 that are divisible by 3.
		// You don't have to use boolean condition.
		// If you do use it, make sure you use a break statement.
		// Look carefully at the output to print EXACTLY that output!
		boolean condition = true;

		int i = 30;
		while ( i > 0 )
		{
			if (i % 3 == 0){
				System.out.println("i = " + i);
			}
			i--;
		}
		System.out.println("Now in reverse!");
		while ( i <= 30 ){
			if (i % 3 == 0){
				System.out.println("i = " + i);
			}
			i++;
		}
	}

	static void Example_5()
	{

		System.out.println("Example 5:");

		Scanner reader = new Scanner(System.in);
		
		// Below is an acceptable way of declaring number.
		// number does not contain anything though, while sum contains 0.
		double number, sum = 0;
		
//		System.out.println(number); 	// Cannot print out un-initialized values.
										// Initialize it or just comment it out. 

		while (true)
		{
			System.out.println("Enter a positive number to continue or a negative number to quit: ");
			number = reader.nextDouble();

			// I don't normally write this way, but this is an acceptable way to write it.
			// break is a command that breaks out of the while loop
			if (number < 0 ) break;

			sum += number;
		}



	}
	static void Collatz_Sequence(){
		Scanner reader = new Scanner(System.in);
		System.out.print("Starting Number: ");

		int n = reader.nextInt();
		int steps = 1;
		int highest_num = 0;

		System.out.print(n + "\t");

		while (n != 1){
			if (n % 2 == 0) {		//Even
				n /= 2;
			} else {				//Odd
				n *= 3;
				n++;
			}
			if (highest_num < n){
				highest_num = n;
			}

			steps++;

			if (steps % 10 == 0) {
				System.out.println(n + "\t");
			} else {
				System.out.print(n + "\t");
			}
		}
		System.out.println();
		System.out.println("Highest Value = " + highest_num);
		System.out.println("Number of steps = " + (steps-1));
	}


}