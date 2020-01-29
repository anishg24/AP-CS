/*
 * Copyright (c) 2020. This project was created by Anish Govind.
 * https://www.github.com/anishg24
 */

package Polymorphism;

import java.util.ArrayList;

public class Manager extends Employee{
    private ArrayList<Employee> subordinates = new ArrayList<Employee>();

    public Manager() {
        this("Manager");
    }

    public Manager(String name){
        super(name);
    }

    public Manager(String name, int ID, double salary){
        super(name, ID, salary);
    }

    public void addEmployee(){
        this.addEmployee(new Employee());
    }

    public void addEmployee(Employee e){
        subordinates.add(e);
    }

    public Employee findEmployee(int ID){
        for (Employee e : subordinates){
            if (e.ID == ID) return e;
        }
        return null;
    }

    public Employee findEmployee(String name){
        for (Employee e : subordinates){
            if (e.name.equals(name)) return e;
        }
        return null;
    }

    public void setSalary(Employee e, double s){
        findEmployee(e.ID).setSalary(s);
    }

    public Manager makeManager(Employee e, double b){
        e.setSalary(e.getSalary()+b);
        return new Manager(e.name, e.ID, e.getSalary());
    }

    public Manager makeManager(String name, double b){
        return this.makeManager(findEmployee(name), b);
    }

    public Manager makeManager(int ID, double b){
        return this.makeManager(findEmployee(ID), b);
    }

    @Override
    public ArrayList<Employee> getSubordinates() {
        return subordinates;
    }
}
