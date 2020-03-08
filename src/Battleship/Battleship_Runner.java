/*
 * Copyright (c) 2020. This project was created by Anish Govind.
 * https://www.github.com/anishg24
 */

package Battleship;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

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

        while (p1.getShipsLeft() != 0 || p2.getShipsLeft() != 0){
            System.out.println(p1.getName() + " it's your turn to shoot!");

        }

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
            else System.out.println("Placed " + ship.getName() + " at (" + row + ", " + col + ")");
        }
    }

    private static void clearScreen() {
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
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

    private static void shoot(){

    }
}
