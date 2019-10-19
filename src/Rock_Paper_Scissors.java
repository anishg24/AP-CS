import java.util.Scanner;

public class Rock_Paper_Scissors {
    public static void main(String[] args) {
        play();
    }

    static void play(){
        // Let the human choose
        Scanner input = new Scanner(System.in);
        System.out.println("Rock, Paper, or Scissors?");
        String choice = input.nextLine().toLowerCase();
        while (choice != "rock" || choice != "paper" || choice != "scissors"){
            System.out.println("Rock, Paper, or Scissors?");
            choice = input.nextLine().toLowerCase();
            System.out.println(choice);
        }
    }

    static boolean check_answer(String answer){
        if (answer == "rock" || answer == "paper" || answer == "scissors") {
            System.out.println("answer = " + answer);
            return false;
        } else return true;
    }
}
