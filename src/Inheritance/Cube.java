/*
 * Copyright (c) 2020. This project was created by Anish Govind.
 * https://www.github.com/anishg24
 */

package Inheritance;

public class Cube extends RectangularPrism {
    public Cube() {
        this(1.);
        this.printWhichConstructors(false);
    }

    public Cube(double side) {
        super(side, side, side);
        super.calculate();
        this.printWhichConstructors(true);
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
}
