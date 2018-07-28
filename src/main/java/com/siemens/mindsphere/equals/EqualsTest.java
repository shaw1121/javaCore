package com.siemens.mindsphere.equals;

/**
 * Created by da5wwf on 7/22/2018.
 */
public class EqualsTest {
    public static void main(String [] args){
        Manager boss = new Manager("zhangxiao", 63333, 1583, 12, 20);
        boss.setBonus(352);

        Employee xiao = new Employee("xiao", 5665, 1900, 2, 5);
        Employee xiao2 = xiao;
        Employee xsojo = new Employee("xsojo", 233, 1932, 1, 4);
        Employee yuan = new Employee("yuan", 23, 2322, 3, 4);

        System.out.println("xiao.toString()" + xiao);

        System.out.println("boss.toString()" + boss);

    }
}
