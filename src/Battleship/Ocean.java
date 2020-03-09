/*
 * Copyright (c) 2020. This project was created by Anish Govind.
 * https://www.github.com/anishg24
 */

package Battleship;

import java.util.Arrays;

public class Ocean {
    private int[][] shape;
    private int size;
    private String[] rowLabels;
    private int[] columnLabels;

    // 0 - Empty
    // 1-5 - Occupied
    // * - Destroyed Spot
    // 69 - Arbitrary number to list a hit on enemy
    // 42 - Arbitrary number to list a miss on enemy

    public Ocean(int size) {
        this.size = size;
        this.shape = new int[size][size];
        for (int[] i : shape) {
            Arrays.fill(i, 0);
        }

        rowLabels = new String[size];
        String x;
        int multiplier = 1;
        for (int i = 0; i < size; i++) {
            x = "";
            if (i >= (26 * multiplier)) multiplier++;
            for (int re = 0; re < multiplier; re++) {
                x = x.concat(String.valueOf((char) ((i - 26 * (i / 26) + 'a'))));
            }
            this.rowLabels[i] = x;
        }

        this.columnLabels = new int[size];
        for (int i = 1; i <= size; i++) {
            this.columnLabels[i - 1] = i;
        }

//        this.shape[0] = this.columnLabels;
//        for (int r = 0; r < this.shape.length; r++){
//            this.shape[r][0] = this.rowLabels[r];
//        }
    }

    public void print() {
        setupGrid();

        for (int r = 0; r < rowLabels.length; r++) {
            System.out.print(rowLabels[r] + "\t│\t"); // USE SYSTEM.OUT.FORMAT
            for (int c : shape[r]) {
                if (c == 69) System.out.print("X\t"); // Hit
                else if (c == 42) System.out.print("M\t"); // Miss
                else System.out.print("\u2610\t"); // Empty
            }
            System.out.println();
        }
    }

    public void print(String message) {
        System.out.println(message);
        this.print();
    }

    public void print(Player player, boolean isClouded) {
        setupGrid();
        String[] rowLabels = player.getOcean().getRowLabels();
        int[][] shape = player.getOcean().getShape();
        for (int r = 0; r < rowLabels.length; r++) {
            System.out.print(rowLabels[r] + "\t│\t"); // USE SYSTEM.OUT.FORMAT
            for (int c : shape[r]) {
                if (c != 0 && player.findShip(c).isDestroyed()) {
                    if (isClouded) System.out.print("X\t"); // Only if hit & a guess board
                    else System.out.print("*\t");
                }
                else if (c == 42) System.out.print("M\t"); // Miss
                else if (c != 0 && !isClouded) System.out.print(c + "\t");
                else System.out.print("\u2610\t"); // Empty
            }
            System.out.println();
        }
    }

    private void setupGrid() {
        System.out.print("X\t│\t");
        String column = "";
        String divider = "";
        for(int n: columnLabels){
            column = column.concat(n + "\t");
            divider = divider.concat("––––");
        }
        divider = divider.concat("–––––");
        System.out.println(column);
        System.out.println(divider);
    }

    public int[][] getShape() {
        return shape;
    }

    public boolean occupySpot(int r, int c, Ship ship) {
//        r--;
//        c--;

        if (ship.isHorizontal()) {
            if (c + ship.getLength() + 1 > size) {
//                System.out.println("You can't place the ship out of bounds! Rotate it or choose somewhere else!");
                return false;
            } else {
                ship.setDeployed(true, r, c);
                for (int col = c; col < ship.getLength() + c; col++) {
                    shape[r][col] = ship.getID();
                }
            }
        } else {
            if (r + ship.getLength() > size) {
//                System.out.println("You can't place the ship out of bounds! Rotate it or choose somewhere else!");
                return false;
            } else {
                ship.setDeployed(true, r, c);
                for (int row = r; row <= ship.getLength() + r; row++) {
                    shape[row][c] = ship.getID();
                }
            }
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    public int[] getColumnLabels() {
        return columnLabels;
    }

    public String[] getRowLabels() {
        return rowLabels;
    }

    public boolean hit(int r, int c, Player p){
        c --;
        Ocean ocean = p.getOcean();
        int zone = ocean.getShape()[r][c];
        if (ocean.getShape()[r][c] != 0) {
            Ship ship = p.findShip(zone);
            boolean is_h = ship.isHorizontal();
            int pos;
            if(is_h) pos = Math.abs(ship.getCoordinates()[0] - c);
            else pos = Math.abs(ship.getCoordinates()[1] - r);
            if (pos == 0) pos ++; // TODO: Create a permanent fix to this error; Ship on c3 will have an error on hit.
            ship.hit(pos);
            this.shape[r][c] = 69;
            return true;
        } else this.shape[r][c] = 42;
        return false;
    }
}
