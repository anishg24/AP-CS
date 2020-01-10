/*
 * Copyright (c) 2020. This project was created by Anish Govind.
 * https://www.github.com/anishg24
 */

package Inheritance;

public class Square extends Rectangle {

    public Square() {
        this(1.);
        System.out.println("I am entering the Square's Normal constructor");
        System.out.println("I am exiting the Square's Normal constructor");
    }

    public Square(double side) {
        super(side, side);
        System.out.println("I am entering the Square's Overloaded constructor");
        System.out.println("I am exiting the Square's Overloaded constructor");
    }

    public double getSide() {
        return super.getLength();
    }

    public void setSide(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    @Override
    public void setLength(double length) {
        this.setSide(length);
    }

    @Override
    public void setWidth(double width) {
        this.setSide(width);
    }

    @Override
    public String toString() {
        return "I am a Square with side of " + this.getSide();
    }
}
