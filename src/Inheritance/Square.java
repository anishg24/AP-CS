/*
 * Copyright (c) 2020. This project was created by Anish Govind.
 * https://www.github.com/anishg24
 */

package Inheritance;

public class Square extends Rectangle {

    public Square() {
        this(1.);
        this.printWhichConstructors(false);
    }

    public Square(double side) {
        super(side, side);
        this.printWhichConstructors(true);
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
}
