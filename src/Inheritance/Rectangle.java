/*
 * Copyright (c) 2020. This project was created by Anish Govind.
 * https://www.github.com/anishg24
 */

package Inheritance;

public class Rectangle {
    private double length;
    private double width;
    private double area;
    private double perimeter;

    public Rectangle() {
        this(1., 2.);
        this.printWhichConstructors(false);
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        this.calculate();
        this.printWhichConstructors(true);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
        this.calculate();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
        this.calculate();
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    protected void calculate() {
        this.area = length * width;
        this.perimeter = 2 * length + 2 * width;
    }

    protected void printWhichConstructors(boolean overloaded){
        String className = this.getClass().getSimpleName();
        if (overloaded) {
            System.out.println("I am entering the " + className + "'s Overloaded constructor");
            System.out.println("I am exiting the " + className + "'s Overloaded constructor");
        } else{
            System.out.println("I am entering the " + className + "'s Normal constructor");
            System.out.println("I am exiting the " + className + "'s Normal constructor");
        }
        if (this.getClass().getSuperclass().getSimpleName().equals("Object")) {
            Class parentClass = this.getClass();
            String parentClassName;
            while (!parentClass.getSimpleName().equals("Object")) {
                parentClassName = parentClass.getSimpleName();
                System.out.println("I am entering the " + parentClassName + "'s Overloaded constructor");
                System.out.println("I am exiting the " + parentClassName + "'s Overloaded constructor");
                parentClass = parentClass.getSuperclass();
            }
        }
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }
}
