package Calculator;

public class Rectangle {
    private double length;
    private double width;
    private static double perimeter;
    private static double area;


    public Rectangle(){
        width = 0;
        length = 0;
        do_math();
    }

    public Rectangle(double l, double w) {
        width = w;
        length = l;
        do_math();
    }

    public void print() {
        System.out.println("This Rectangle has a length of " + length + " and a width of " + width + ".");
        System.out.println("The area of the rectangle is: " + area);
        System.out.println("The perimeter of the rectangle is: " + perimeter);
    }

    public void setWidth(double v) {
        width = v;
        System.out.println("The width has been changed to: " + width);
        do_math();
    }

    public void setLength(double v) {
        length = v;
        System.out.println("The length has been changed to: " + length);
        do_math();
    }

    private void do_math(){
        perimeter = (2*length) + (2*width);
        area = length * width;
    }

    public static double getArea() {
        return area;
    }

    public double getLength() {
        return length;
    }

    public static double getPerimeter() {
        return perimeter;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "Rectangle with length: " + length + " and width: " + width;
    }
}
