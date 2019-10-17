package Classes;

public class Triangle {

    private static double base;
    private static double height;
    private static double perimeter;
    private static double area;


    public Triangle(){
        base = 0;
        height = 0;
        do_math();
    }

    public Triangle(double b, double h) {
        base = b;
        height = h;
        do_math();
    }

    public void print() {
        System.out.println("This Rectangle has a base of " + base + " and a height of " + height + ".");
        System.out.println("The area of the triangle is: " + area);
        System.out.println("The perimeter of the triangle is: " + perimeter);
    }

    private void do_math(){
        area = 0.5*(base*height);
        // base + height + root(b^2+h^2)
        perimeter = base + height + Math.sqrt((base*base) + (height*height));
    }


    public void setBase(double v) {
        base = v;
        do_math();
    }

    public void setHeight(double v){
        height = v;
        do_math();
    }

    public static double getBase(){
        return base;
    }

    public static double getHeight(){
        return height;
    }

    public static double getArea() {
        return area;
    }

    public static double getPerimeter() {
        return perimeter;
    }
}
