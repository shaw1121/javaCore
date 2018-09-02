package com.siemens.mindsphere.domain;

/**
 * @author Zhang Xiao
 * @date 8/31/2018 14:35
 */
public class Student extends Person {
    public Student(String name, int age) {
        super(name, age);
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
