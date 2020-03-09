/*
 * Copyright (c) 2020. This project was created by Anish Govind.
 * https://www.github.com/anishg24
 */

package Battleship;

import java.util.Arrays;

public class Ship {
    public static int ship_count;
    private String name;
    private int length;
    private boolean[][] shape;
    private int ID;
    private boolean is_horizontal = true;
    private boolean deployed = false;
    private int[] coordinates = new int[2];
    private boolean hit = false;

    public Ship(String name, int length, int ID) {
        this.name = name;
        this.length = length;
        this.ID = ID;
        ship_count++;
        this.generateShape();
    }

    public static int getShip_count() {
        return ship_count;
    }

    public static void setShip_count(int ship_count) {
        Ship.ship_count = ship_count;
    }

    public boolean isDeployed() {
        return deployed;
    }

    public void setDeployed(boolean deployed, int r, int c) {
        this.coordinates[0] = r;
        this.coordinates[1] = ++c;
        this.deployed = deployed;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public int getID() {
        return ID;
    }

    public boolean isHorizontal() {
        return is_horizontal;
    }

    public boolean isDestroyed() {
        boolean b = true;
        for (boolean[] r : this.shape) {
            for (boolean c : r) {
                if (!c) {
                    b = false;
                    break;
                }
            }
        }
        return b;
    }

    public void rotate() {
        is_horizontal = !is_horizontal;
        generateShape();
    }

    // false - not hit
    // true - hit

    public void hit(int pos) {
        try {
            if (is_horizontal) this.shape[0][pos-1] = true;
            else this.shape[pos-1][0] = true;
            this.hit = true;
        } catch (Exception ignored) {
            System.out.println("ERROR");
        }
    }

    protected void generateShape() {
        if (is_horizontal) this.shape = new boolean[1][length];
        else this.shape = new boolean[length][1];
        for (int r = 0; r < shape.length; r++) {
            for (int c = 0; c < shape[r].length; c++) {
                this.shape[r][c] = false;
            }
        }
    }

    public boolean[][] getShape() {
        return shape;
    }

    public void nuke() {
        for (int i = 1; i <= this.length; i++) {
            this.hit(i);
        }
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", ID=" + ID +
                ", is_horizontal=" + is_horizontal +
                ", deployed=" + deployed +
                ", coordinates=" + Arrays.toString(coordinates) +
                ", hit=" + hit +
                '}';
    }

    public boolean isHit(){
        return hit;
    }
}

