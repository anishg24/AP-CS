/*
 * Copyright (c) 2020. This project was created by Anish Govind.
 * https://www.github.com/anishg24
 */

package Battleship;

public class Player {
    private Ship[] navy;
    private Ocean ocean;
    private Ocean guessOcean;
    private String name;
    public Player(String name) {
        navy = new Ship[5];
        navy[0] = new Ship("Carrier", 5, 1);
        navy[1] = new Ship("Battleship", 4, 2);
        navy[2] = new Ship("Destroyer", 3, 3);
        navy[3] = new Ship("Submarine", 3, 4);
        navy[4] = new Ship("PT Boat", 2, 5);

        ocean = new Ocean(12);
        guessOcean = new Ocean(12);
        this.name = name;
    }

    public Ship[] getNavy() {
        return navy;
    }

    public String getName() {
        return name;
    }

    public Ocean getGuessOcean() { return guessOcean; }

    public int getShipsLeft() {
        int ships_left = 0;
        for (Ship s : navy) {
            if (!s.isDestroyed()) ships_left++;
        }
        return ships_left;
    }

    public void printOcean() {
        System.out.println(name + "'s Ocean:");
        this.ocean.print(this, false);
    }

    public void printGuessOcean(Player p){
        this.guessOcean.print(p, true);
    }

    public Ship findShip(int ID) {
        Ship result = null;
        for (Ship s : navy) {
            if (s.getID() == ID) result = s;
        }
        return result;
    }

    public Ocean getOcean() {
        return ocean;
    }

    public Ship findShip(String name) {
        Ship result = null;
        for (Ship s : navy) {
            if (s.getName().toLowerCase().equals(name.toLowerCase())) result = s;
        }
        return result;
    }

    public boolean placeShip(int r, int c, Ship s) {
        if(this.ocean.getShape()[r][c] == 0) {
            if(!this.ocean.occupySpot(r, c, s)) {
                s.rotate();
                System.out.println("Original rotation didn't work, so we rotated your ship!");
            }
            return this.ocean.occupySpot(r, c, s);
        }
        else return false;
    }

    public void printShips() {
        System.out.println(name + "'s Navy: ");
        String status;
        String display_format;
        for (Ship c : navy) {
            if (c.isDestroyed()) status = "DESTROYED";
            else if (c.isHit()) status = "DAMAGED";
            else if (c.isDeployed()) status = "DEPLOYED";
            else status = "READY TO FIGHT";

            display_format = "> ID: %-1d | %-10s [%-" + status.length() +"s]%n";

            System.out.format(display_format, c.getID(), c.getName(), status);

//            System.out.println(c.getName() + " [" + status + "]");
        }
    }

    public boolean isAllShipsDeployed(){
        for(Ship s: navy){
            if(!s.isDeployed()) return false;
        }
        return true;
    }

    public void shoot(int r, int c, Player p2){
        Ocean enemy_waters = p2.getOcean();
    }
}
