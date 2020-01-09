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
        this.printWhichConstructors(false);
    }

    public RectangularPrism(double height) {
        this(1, 2, height);
        this.printWhichConstructors(true);
    }

    public RectangularPrism(double length, double width, double height) {
        super(length, width);
        this.height = height;
        this.calculate();
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
}
