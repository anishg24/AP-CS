import java.util.Scanner;

public class Lab_3
{

	public static void main(String[] args)
	{
		/*
		 * In this lab, you will learn if conditional statements.
		 * 
		 */
		
		int of_age = 16;
		int age = 0;
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("Example 1:");
		// Example 1
		// The logic of if else statements are simple in nature.
		
		System.out.println("How old are you");
		age = read.nextInt();
		
		if (age >= of_age) // checks if the age of the person is 16 or above.
		{
			System.out.println("You can legally get a permit");
		}
		else
		{
			System.out.println("You cannot legally get a permit.");
		}
		
		/*
		System.out.println("Example 2:");
		// Example 2

		// Scanner is already initiated.
		System.out.println("a = ");
		double a = read.nextDouble();
		System.out.println("b = ");
		double b = read.nextDouble();
		System.out.println("c = ");
		double c = read.nextDouble();
		
		double discriminant = (b*b)-(4*a*c);
		if (discriminant > 0)
		{
			System.out.println("The quadratic has two real solution.");
		}
		else if (discriminant == 0)
		{
			System.out.println("The quadratic has 1 solution.");
		}
		else
		{
			System.out.println("The quadratic has no real solution");
		}
		*/
		
		/*
		System.out.println("Example 3:");
		// Example 3:
		
		int count = 0;
		
		// Look carefully, line by line what is actually getting checked.
		if (count >= 0)
		{
			System.out.println("This will always true");
			System.out.println("Count = " + count);
			count++; 
		}
		else if (count < 0)  
		{
			System.out.println("This will NEVER print");
		}
		// Note that you don't have to have a final else statement.
		
		*/
		
		/*
		System.out.println("Example 4:");
		//Example 4
		
		double percentage = read.nextDouble();
		
		if (percentage < 60)
		{
			System.out.println("Your grade is an F");
		}
		if (percentage >= 60 && percentage < 70)
		{
			System.out.println("Your grade is an D");
		}
		if (percentage >= 70 && percentage < 80)
		{
			System.out.println("Your grade is an C");
		}
		if (percentage >= 80 && percentage < 90)
		{
			System.out.println("Your grade is an B");
		}
		else
		{
			System.out.println("Your grade is an A");
		}
		
		*/
		
		//Write your own code:
		/*
		 * Please create a new Java Project.
		 * Create a class file in the SRC folder.
		 * Title it Mini_Project_1
		 * Make sure to check off the box for public static void main...
		 */
	}
}



