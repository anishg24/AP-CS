package Classes;

public class Circle {

    private static double radius;
    private static double area;
    private static double circumference;

    public Circle(){
        radius = 0;
        do_math();
    }

    public Circle(double r) {
        radius = r;
        do_math();
    }

    public void print() {
        System.out.println("This Circle has a radius of " + radius + ".");
        System.out.println("The area of the circle is: " + area);
        System.out.println("The circumference of the circle is: " + circumference);
    }

    public void set_radius(double i) {
        radius = i;
        System.out.println("The radius was changed to: " + i);
        do_math();
    }

    private void do_math(){
        circumference = 2*Math.PI*radius;
        area = Math.PI*(radius * radius);
    }

    public static double getArea() {
        return area;
    }

    public static double getCircumference() {
        return circumference;
    }

    public static double getRadius() {
        return radius;
    }
}
