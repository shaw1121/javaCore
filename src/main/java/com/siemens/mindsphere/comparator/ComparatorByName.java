package com.siemens.mindsphere.comparator;

import com.siemens.mindsphere.domain.Student;

import java.util.Comparator;

/**
 * @author Zhang Xiao
 * @date 9/2/2018 23:05
 */
public class ComparatorByName implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int temp = o1.getName().compareTo(o2.getName());
        return temp==0?o1.getAge() - o2.getAge() : temp;
    }

}
