import java.util.Scanner;

public class Crack_The_Combo {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int guess = 0;
        int count = 1;
        int blaze_it = 420;
        int num_screw_ups = 0;
        while((guess != blaze_it) && (count <= 10)){
            System.out.println("Guess #" + count);
            guess = read.nextInt();
            if (guess < 100 || guess > 999){
                System.out.println("Enter a three digit number! (100-999)");
                num_screw_ups ++;
                if (num_screw_ups >= 20){
                    System.out.println("Clearly since you are an ape and don't know how to use a computer, I've ended this game.");
                    count = 10000;
                }
            } else if (guess != blaze_it) {
                System.out.println("You weren't correct");
                count++;
            }
        }
        if (guess == blaze_it)
            System.out.println("WIN!");
        else
            System.out.println("LOSE!");
    }
}
