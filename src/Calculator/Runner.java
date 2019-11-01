package Calculator;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        Rectangle a = new Rectangle(2.0,4.0);
        Rectangle b = new Rectangle(1.0,2.0);


        System.out.println("c.add(1,1) = " + c.add(1,1));
        System.out.println("c.add(1,1.0) = " + c.add(1,1.0));
        System.out.println("c.add(new {1,2,3,4}, 1) = " + Arrays.toString(c.add(new int[]{1, 2, 3, 4}, 1)));
        System.out.println("c.add(1.0,2.0) = " + c.add(1.0,2.0));
        System.out.println("c.add(a,b) = " + c.add(a,b));
        System.out.println("c.add(1,2,3) = " + c.add(1,2,3));

        System.out.println();

        System.out.println("c.subtract(4,1) = " + c.subtract(4,1));
        System.out.println("c.subtract(4.0,3.0) = " + c.subtract(4.0,3.0));
        System.out.println("c.subtract(new int[]{1,2,3,4}, 5.0) = " + Arrays.toString(c.subtract(new int[]{1, 2, 3, 4}, 5.0)));
        System.out.println("c.subtract(a,b) = " + c.subtract(a,b));

        System.out.println();

        System.out.println("c.div(6.0,2.0) = " + c.div(6.0,2.0));
        System.out.println("c.div(new int[]{2,4,6,8}, 2.0) = " + Arrays.toString(c.div(new int[]{2, 4, 6, 8}, 2.0)));
        System.out.println("c.div(a, 2.0) = " + c.div(a, 2.0));

        System.out.println();

        System.out.println("c.mult(1,2) = " + c.mult(1,2));
        System.out.println("c.mult(1.2,5) = " + c.mult(1.2,5));
        System.out.println("c.mult(1,2.0) = " + c.mult(1,2.0));
        System.out.println("c.mult(new int[]{1,2,3,4}, 2.0) = " + Arrays.toString(c.mult(new int[]{1, 2, 3, 4}, 2.0)));
        System.out.println("c.mult(a, 2.0) = " + c.mult(a, 2.0));

        System.out.println();

        System.out.println("c.mult(2, \"temp\") = " + c.mult(2, "temp"));
        System.out.println("c.mult(3.5, \"test\") = " + c.mult(3.5, "test"));

        System.out.println("\nDone testing!");
    }
}
