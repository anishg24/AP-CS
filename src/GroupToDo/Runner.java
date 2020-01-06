package GroupToDo;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<Player>();
        int rounds = 0;

        for (int i = 0; i < 10; i ++){
            players.add(new Player("Player #" + i));
        }
        print_header(players);
        System.out.println();
        while(check_winners(players) == null){
            roll_all(players);
            rounds ++;
            print_row(players);
            System.out.println();
        }

        System.out.println("\nWinner after " + rounds + " rounds");
        ArrayList<Player> winners = check_winners(players);
        assert winners != null;
        for(Player winner : winners){
            System.out.println("WINNER: " + winner);
        }
    }
    public static void roll_all(ArrayList<Player> arr){
        for (Player p : arr){
            p.roll();
        }
    }

    public static ArrayList<Player> check_winners(ArrayList<Player> arr){
        ArrayList<Player> result = new ArrayList<Player>();
        for (Player p: arr){
            if (p.getPoints() == 21) result.add(p);
            else if (p.getPoints() > 21) p.setPoints(0);
        }
        if (result.size() == 0) return null;
        return result;
    }

    public static void print_header(ArrayList<Player> arr){
        System.out.println(Player.count + " players:");
        for (Player p : arr){
            System.out.print(p.getName() + "\t");
        }
    }

    public static void print_row(ArrayList<Player> arr){
        for(Player p : arr){
            System.out.print(p.getPoints() + "\t\t\t");
        }
    }
}
