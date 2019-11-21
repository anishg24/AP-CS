package Object_Arrays;

import Blackjack.scanner.scanners.precisiondouble.DoubleInputScanner;

import java.util.Arrays;

public class Classroom {
    public static void main(String[] args) {
        Student[] classA = populateClass(new Student[15]);
        Student[] classB = populateClass(new Student[15]);
        System.out.println("Made 2 classes of 15 students");
        System.out.println("Student.studentCount = " + Student.studentCount);
        System.out.println();
        Student[] classC = populateClass(new Student[30]);
        System.out.println("Initialized 30 students");
        System.out.println("Student.studentCount = " + Student.studentCount);
        System.out.println();
        System.out.println(Arrays.toString(classC));
        System.out.println(Arrays.toString(Place_in_front(classC, 3)));
        
    }

    public static Student[] populateClass(Student[] arr){
        int random;
        String suffix;
        for (int i = 0; i < arr.length; i++){
            if (i > 9 && i < 21)
                suffix = "th";
            else if (i%10 == 1)
                suffix = "st";
            else if (i%10 == 2)
                suffix = "nd";
            else if (i%10 == 3)
                suffix = "rd";
            else
                suffix = "th";

            random = (int)(4*Math.random());
            if (random == 0)
                arr[i] = new Student();
            else if (random == 1)
                arr[i] = new Student("Bob", "the " + i + suffix);
            else if (random == 2)
                arr[i] = new Student("Joe", "John", "the " + i + suffix);
            else if (random == 3)
                arr[i] = new Student("James", "Jacob", "the " + i + suffix, 10);
        }
        return arr;
    }

    public static Student find_Shortest(Student[] arr){
        Student result = null;
        double temp = Double.NEGATIVE_INFINITY;
        for (Student stu : arr){
            if (stu.getHeight() < temp)
                result = stu;
        }
        return result;
    }

    public static Student[] find_Shortest(Student[] a, Student[] b){
        Student[] result = null;
        double a_heights = 0;
        double b_heights = 0;
        for (Student stu : a){
            a_heights += stu.getHeight();
        }
        for (Student stu : b){
            b_heights += stu.getHeight();
        }

        if (a_heights > b_heights)
            result = b;
        else
            result = a;
        return result;
    }

    public static Student find_Student(Student[] arr, Student[] barr, String name){
        Student result = null;
        for (Student stu : arr){
            if (stu.getName().equals(name)){
                result = stu;
                break;
            }
        }
        if (result == null) {
            for (Student stu : barr) {
                if (stu.getName().equals(name)) {
                    result = stu;
                    break;
                }
            }
        }
        return result;
    }

    public static Student[] swap_Location(Student[] arr, int i1, int i2){
        Student temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;

        return arr;
    }

    public static Student[] Place_in_front(Student[] arr, int index){
        Student target = arr[index];
        Student[] result = new Student[arr.length];
        for (int i = 0; i < result.length; i ++){
            try {
                result[i + 1] = arr[i];
            }
            catch (Exception ignored){
            }
        }
        result[0] = target;
        return result;
    }
}
