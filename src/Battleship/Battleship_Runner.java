/*
 * Copyright (c) 2020. This project was created by Anish Govind.
 * https://www.github.com/anishg24
 */

package Battleship;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Battleship_Runner {

    public static void main(String[] args) {
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");

        setup(p1);
        clearScreen();
        clearScreen();
        setup(p2);
        clearScreen();
        clearScreen();

//        int limit = p1.getOcean().getSize();
//
//        p1.placeShip(1, 2, p1.findShip(1));
//        p1.placeShip(2, 2, p1.findShip(2));
//        p1.placeShip(3, 2, p1.findShip(3));
//        p1.placeShip(4, 2, p1.findShip(4));
//        p1.placeShip(5, 2, p1.findShip(5));
//
//        p2.placeShip(1, 2, p2.findShip(1));
//        p2.placeShip(2, 2, p2.findShip(2));
//        p2.placeShip(3, 2, p2.findShip(3));
//        p2.placeShip(4, 2, p2.findShip(4));
//        p2.placeShip(5, 2, p2.findShip(5));
//
//        for(Ship s : p2.getNavy()){
//            if (s.getID() == 1) continue;
//            else s.nuke();
//        }

//        p1.getGuessOcean().hit(1, 3, p2);
//        p1.printGuessOcean(p2);
//        Ship s = p2.findShip(1);
//        System.out.println(Arrays.deepToString(s.getShape()));
//        p1.getGuessOcean().hit(2, 3, p2);
//        p1.printGuessOcean(p2);
//        Ship s = p2.findShip(2);
//        System.out.println(Arrays.deepToString(s.getShape()));
//        p1.getGuessOcean().hit(3, 3, p2);
//        p1.printGuessOcean(p2);
//        Ship s = p2.findShip(3);
//        System.out.println(Arrays.deepToString(s.getShape()));

        while (p1.getShipsLeft() != 0 || p2.getShipsLeft() != 0){
            shoot(p1, p2);
            if (p2.getShipsLeft() == 0) break;
            System.out.println("Get ready to pass the game!");
            sleep(3);
            clearScreen();
            clearScreen();
            shoot(p2, p1);
            if (p1.getShipsLeft() == 0) break;
            System.out.println("Get ready to pass the game!");
            sleep(3);
            clearScreen();
            clearScreen();
        }
        clearScreen();
        if (p1.getShipsLeft() == 0) System.out.println(p2.getName() + " wins!");
        else System.out.println(p1.getName() + " wins!");
    }

    private static void setup(Player p) {
        Ship ship;
        System.out.println(p.getName() + " it's your turn to place your ships!");

        while(!p.isAllShipsDeployed()) {
            p.printShips();
            System.out.println();
            p.printOcean();

            System.out.print("Enter a valid ship name or ID: ");
            ship = getShip(p);

            while (ship.isDeployed()) {
                System.out.println(ship.getName() + " is already deployed! Choose another: ");
                ship = getShip(p);
            }

            int limit = p.getOcean().getSize();
            String[] rows = p.getOcean().getRowLabels();
            int row = getRow("What row do you want to place your " + ship.getName() + "? ", rows);
            int col = getColumn("What column do you want to place your " + ship.getName() + "? ", limit) - 1;

            System.out.println(row);
            System.out.println(col);

            while(p.getOcean().getShape()[row][col] != 0) {
                System.out.println("(" + rows[row] +", " + col + ") is occupied!");
                row = getRow("What row do you want to place your " + ship.getName() + "? ", rows);
                col = getColumn("What column do you want to place your " + ship.getName() + "? ", limit);
            }
            if (!p.placeShip(row, col, ship))System.out.println("You can't place your ship there!");
            else {
                clearScreen();
                System.out.println("Placed " + ship.getName() + " at (" + row + ", " + col + ")");
            }
        }
        clearScreen();
    }

    private static void clearScreen() {
        System.out.println(new String(new char[100]).replace("\0", "\r\n"));
    }

    private static int getRow(String message, String[] rowLabels){
        System.out.print(message);
        int index = Arrays.asList(rowLabels).indexOf(getRowChoice());
        while(index < 0){
            System.out.println("That isn't within the available rows! (" + rowLabels[0] + "-" + rowLabels[rowLabels.length-1] +")");
            System.out.print("Enter a valid letter: ");
            index = Arrays.asList(rowLabels).indexOf(getRowChoice());
        }

        return index;
    }

    private static String getRowChoice() {
        Scanner read = new Scanner(System.in);
        String choice;
        while(true){
            try{
                choice = read.next();
                break;
            } catch (InputMismatchException ignored){
                read.next();
                System.out.println("That isn't a letter!");
                System.out.print("Enter a letter: ");
            }
        }
        return choice;
    }

    private static int getColumn(String message, int limit){
        Scanner read = new Scanner(System.in);
        int c;

        System.out.print(message);

        while(true){
            try{
                c = read.nextInt();
                break;
            } catch (InputMismatchException ignored){
                read.next();
                System.out.println("That isn't a valid number!");
                System.out.print("Enter a valid number: ");
            }
        }

        while (c > limit || c < 0) {
            System.out.print("That is outside of the board! Choose something less than " + limit + ": ");
            while(true){
                try{
                    c = read.nextInt();
                    break;
                } catch (InputMismatchException ignored){
                    read.next();
                    System.out.println("\nThat isn't a valid number!");
                    System.out.print("Enter a valid number: ");
                }
            }
        }
        return c;
    }

    private static Ship getShip(Player p){
        Scanner read = new Scanner(System.in);
        Ship ship = null;
        String choice;
        while(ship == null){
            choice = read.nextLine();
            ship = p.findShip(choice);
            if (ship == null) {
                try {
                    ship = p.findShip(Integer.parseInt(choice));
                } catch (NumberFormatException ignored) {
                    System.out.print("Enter valid ship name or ID: ");
                }
            }
        }
        return ship;
    }

    private static void shoot(Player main, Player target) {
        int limit = target.getOcean().getSize();
        System.out.println(main.getName() + " it's your turn to shoot!");
        main.printGuessOcean(target);
        int row = getRow("What row do you want to shoot at? ", main.getOcean().getRowLabels());
        int col = getColumn("What column do you want to shoot at? ", limit);
        clearScreen();
        boolean a = main.getGuessOcean().hit(row, col, target);
        main.printGuessOcean(target);
        if (a) System.out.print("HIT");
        else System.out.print("MISS");
        System.out.println( " at (" + row + ", " + col +")!");
    }

    private static void sleep(int s){
        try {
            TimeUnit.SECONDS.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
