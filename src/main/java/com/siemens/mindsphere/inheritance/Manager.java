package com.siemens.mindsphere.inheritance;

/**
 * Created by da5wwf on 7/21/2018.
 */
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day){
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getSalary(){
        return super.getSalary() + bonus;
    }

    public void setBonus(double b){
        bonus = b;
    }
}
