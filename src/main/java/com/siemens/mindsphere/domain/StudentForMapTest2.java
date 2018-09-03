package com.siemens.mindsphere.domain;

import java.util.Objects;

/**
 * @author Zhang Xiao
 * @date 9/3/2018 19:14
 */
public class StudentForMapTest2 implements Comparable<StudentForMapTest2> {

    private String name;
    private int age;

    public StudentForMapTest2() {
        super();
    }

    public StudentForMapTest2(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentForMapTest2 that = (StudentForMapTest2) o;
        return age == that.age &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int compareTo(StudentForMapTest2 o) {

        int temp = this.age - o.age;

        return temp==0?this.name.compareTo(o.name):temp;
    }

}
