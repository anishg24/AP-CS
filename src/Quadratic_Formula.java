import java.util.Arrays;
import java.util.Scanner;
import java.math.*;

public class Quadratic_Formula {
    public static void main(String[] args) {
        double[] result = quadratic_formula(1,2);
        System.out.println("result = " + result[0] + " " + result[1]);
    }
    public static double[] quadratic_formula(double a, double b, double c){
        double[] result;
        double discriminant = (b*b) - (4*a*c);

        if (discriminant < 0 ){
            System.out.println("There are no real roots!");
            result = new double[]{Double.NaN, Double.NaN};
        } else {

            double denominator = 2 * a;

            double pos_result = (-b + Math.sqrt(discriminant)) / denominator;
            double neg_result = (-b - Math.sqrt(discriminant)) / denominator;

            result = new double[]{pos_result, neg_result};
        }
        return result;
    }

    public static double[] quadratic_formula(){
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the a, b, and c values and let me solve the rest!");

        System.out.print("a = ");
        double a = read.nextDouble();

        System.out.print("b = ");
        double b = read.nextDouble();

        System.out.print("c = ");
        double c = read.nextDouble();

        return quadratic_formula(a,b,c);

    }
    public static double[] quadratic_formula(double first, double second){
        Scanner read = new Scanner(System.in);
        double a = Double.NaN;
        double b = Double.NaN;
        double c = Double.NaN;

        String[] available_options = {"a", "b", "c"};

        System.out.println("What values did you give me by default?");
        print_options(available_options);

        System.out.print(" = " + first + " ");
        String choice = read.nextLine();

        if (choice.equals("a")){
            a = first;
            available_options[0] = "";
        } else if (choice.equals("b")){
            b = first;
            available_options[1] = "";
        } else if (choice.equals("c")){
            c = first;
            available_options[2] = "";
        } else {
            System.out.println("Enter a valid number!");
            quadratic_formula(first, second);
        }

        System.out.println("What other value did you give me?");
        print_options(available_options);

        System.out.print(" = " + second + " ");
        choice = read.nextLine();

        if (choice.equals("a") && Arrays.asList(available_options).contains("a")){
            a = second;
        } else if (choice.equals("b") && Arrays.asList(available_options).contains("b")){
            b = second;
        } else if (choice.equals("c") && Arrays.asList(available_options).contains("c")){
            c = second;
        } else {
            quadratic_formula(first, second);
        }

        if (Double.isNaN(a)){
            System.out.print("a = ");
            a = read.nextDouble();
        } else if (Double.isNaN(b)){
            System.out.print("b = ");
            b = read.nextDouble();
        } else if (Double.isNaN(c)){
            System.out.print("c = ");
            c = read.nextDouble();
        }

        return quadratic_formula(a,b,c);
    }

    public static double[] quadratic_formula(double first){
        Scanner read = new Scanner(System.in);
        double a = Double.NaN;
        double b = Double.NaN;
        double c = Double.NaN;

        String[] available_options = {"a", "b", "c"};

        System.out.println("What value did you give me by default?");
        print_options(available_options);

        System.out.print(" = " + first + " ");
        String choice = read.nextLine();

        if (choice.equals("a")){
            a = first;
            available_options[0] = "";
        } else if (choice.equals("b")){
            b = first;
            available_options[1] = "";
        } else if (choice.equals("c")){
            c = first;
            available_options[2] = "";
        } else {
            System.out.println("Enter a valid number!");
            quadratic_formula(first);
        }

        for (int i = 0; i<2; i++) {
            if (Double.isNaN(a)) {
                System.out.print("a = ");
                a = read.nextDouble();
            } else if (Double.isNaN(b)) {
                System.out.print("b = ");
                b = read.nextDouble();
            } else if (Double.isNaN(c)) {
                System.out.print("c = ");
                c = read.nextDouble();
            }
        }
        return quadratic_formula(a,b,c);
    }

    public static void print_options(String[] available_options){
        System.out.print("(");
        for (String option : available_options){
            System.out.print(option);
            if (option.equals("a") || option.equals("b")){
                System.out.print("/");
            }
        }
        System.out.print(")");
    }

}

