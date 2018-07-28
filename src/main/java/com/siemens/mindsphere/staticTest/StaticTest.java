package com.siemens.mindsphere.staticTest;

import java.time.LocalDate;

/**
 * Created by da5wwf
 * on 7/19/2018 20:49.
 */
public class StaticTest {
    public static void main(String[] args){
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("zhang", 5000, 1988, 12, 1);
        staff[1] = new Employee("xiao", 2333, 2334, 12, 1);
        staff[2] = new Employee("yuan", 2334, 4322, 1, 1);

        for(Employee e: staff)
            e.raiseSalary(5);

        for(Employee e: staff)
            System.out.println("name = " + e.getName() + ", salary = " + e.getSalary() + ", hireDay = " + e.getHireDay());
    }
}

class Employee{
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String n, double s, int year, int month, int day){
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public LocalDate getHireDay(){
        return hireDay;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent;
        salary += raise;
    }
}

