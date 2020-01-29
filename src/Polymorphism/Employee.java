/*
 * Copyright (c) 2020. This project was created by Anish Govind.
 * https://www.github.com/anishg24
 */

package Polymorphism;

import java.util.ArrayList;

public class Employee {
    public static int employee_count;
    public String name;
    public int ID;
    private double salary;

    public Employee() {
        this("Employee #"+employee_count);
    }

    public Employee(String name) {
        this(name, employee_count, 70000);
        employee_count++;
    }

    public Employee(String name, int ID, double salary) {
        this.name = name;
        this.ID = ID;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ArrayList<Employee> getSubordinates(){
        return null;
    }
}
