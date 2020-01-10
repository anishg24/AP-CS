/*
 * Copyright (c) 2020. This project was created by Anish Govind.
 * https://www.github.com/anishg24
 */

package Inheritance;

public class Cube extends RectangularPrism {
    public Cube() {
        this(1.);
        System.out.println("I am entering the Cube's Normal constructor");
        System.out.println("I am exiting the Cube's Normal constructor");
    }

    public Cube(double side) {
        super(side, side, side);
        super.calculate();
        System.out.println("I am entering the Cube's Overloaded constructor");
        System.out.println("I am exiting the Cube's Overloaded constructor");
    }

    public double getSide() {
        return super.getLength();
    }

    public void setSide(double side) {
        super.setLength(side);
        super.setWidth(side);
        super.setHeight(side);
    }

    @Override
    public void setHeight(double height) {
        this.setSide(height);
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
        return "I am a Cube with side of " + this.getSide();
    }
}
