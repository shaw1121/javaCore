package com.siemens.mindsphere.inheritance;

/**
 * Created by da5wwf on 7/21/2018.
 */
public class ManagerTest {
    public static void main(String [] args){
        Manager boss = new Manager("zhangxiao", 63333, 1583, 12, 20);
        boss.setBonus(352);

        Employee[] staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("xsojo", 233, 1932, 1, 4);
        staff[2] = new Employee("yuan", 23, 2322, 3, 4);

        for (Employee e: staff){
            System.out.println("name: " + e.getName() + "salary: " + e.getSalary() + e.toString());
        }

    }
}
