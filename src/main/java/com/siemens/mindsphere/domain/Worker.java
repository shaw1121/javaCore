package com.siemens.mindsphere.domain;

/**
 * @author Zhang Xiao
 * @date 8/31/2018 15:07
 */
public class Worker extends Person {
    public Worker(String name, int age) {
        super(name, age);
    }

    public Worker() {
        super();
    }

    public String toString(){
        return "Worker{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }

}
