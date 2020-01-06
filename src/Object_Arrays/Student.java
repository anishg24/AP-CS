package Object_Arrays;

import java.util.Arrays;

public class Student {
    public static int studentCount;
    public Student classPartner;
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private int ID;
    private double height;
    private double[] grades = new double[6];

    public Student() {
        studentCount++;
        height = ((Math.random() * 2) + 5) * 12;

        for (int i = 0; i < grades.length; i++) {
            grades[i] = Math.random() * 100;
        }
    }

    public Student(String firstName, String lastName) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String middleName, String lastName) {
        this(firstName, lastName);
        this.middleName = middleName;
    }

    public Student(String firstName, String middleName, String lastName, int age) {
        this(firstName, middleName, lastName);
        this.age = age;
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public static void setStudentCount(int studentCount) {
        Student.studentCount = studentCount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return firstName + " " + middleName + " " + lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double[] getGrades() {
        return grades;
    }

    public Student getClassPartner() {
        return classPartner;
    }

    public void setClassPartner(Student classPartner) {
        this.classPartner = classPartner;
        this.classPartner.setClassPartner(this);
    }

    public void displayGrades() {
        System.out.println(Arrays.toString(grades));
    }

    public double calculateGPA() {
        int sum = 0;
        double grade;
        for (int i = 0; i < grades.length; i++) {
            grade = grades[i];
            if (grade < 100 && grade >= 90)
                sum += 4;
            else if (grade < 90 && grade >= 80)
                sum += 3;
            else if (grade < 80 && grade >= 70)
                sum += 2;
            else if (grade < 70 && grade >= 60)
                sum += 1;
            else sum += 0;
        }
        return sum / 6.0;
    }

    @Override
    public String toString() {
//        return this.getName();
        return firstName + " " + lastName + " is " + age + " years old with a height of " + height;
    }
}
