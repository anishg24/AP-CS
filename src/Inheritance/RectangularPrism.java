/*
 * Copyright (c) 2020. This project was created by Anish Govind.
 * https://www.github.com/anishg24
 */

package Inheritance;

public class RectangularPrism extends Rectangle {
    private double height;
    private double volume;
    private double surfaceArea;

    public RectangularPrism() {
        this(1, 2, 3);
        System.out.println("I am entering the RectangularPrism's Normal constructor");
        System.out.println("I am exiting the RectangularPrism's Normal constructor");
    }

    public RectangularPrism(double height) {
        this(1, 2, height);
        System.out.println("I am entering the RectangularPrism's Overloaded constructor");
        System.out.println("I am exiting the RectangularPrism's Overloaded constructor");
    }

    public RectangularPrism(double length, double width, double height) {
        super(length, width);
        this.height = height;
        this.calculate();
        System.out.println("I am entering the RectangularPrism's Overloaded constructor");
        System.out.println("I am exiting the RectangularPrism's Overloaded constructor");
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        this.calculate();
    }

    public double getVolume() {
        return volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    @Override
    protected void calculate() {
        super.calculate();
        this.volume = this.getLength() * this.getWidth() * this.height;
        this.surfaceArea = 2 * this.getArea() + this.getPerimeter() * this.height;
    }

    @Override
    public String toString() {
        return "I am a Rectangular Prism with width" + this.getWidth() + " and a length of " + this.getLength() +
                " and a height of " + this.getHeight();
    }
}
