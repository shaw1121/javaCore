package com.siemens.mindsphere.generic;

import com.siemens.mindsphere.domain.Person;
import com.siemens.mindsphere.domain.Student;
import com.siemens.mindsphere.domain.Worker;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Zhang Xiao
 * @date 9/2/2018 20:26
 */
public class GenericDemo9 {

    public static void main(String[] args){
        /**
         * 泛型的限定在API中的体现，下限的体现
         * TreeSet(Comparator<? super E> comparator)
         */
        //创建一个集合存储的是学生对象。想要按照姓名排序。
        TreeSet<Student> ts = new TreeSet<Student>(new ComparatorByName());
        ts.add(new Student("abc",26));
        ts.add(new Student("aaa",29));
        ts.add(new Student("lisi",20));

        for (Iterator<Student> it = ts.iterator();it.hasNext();){
            Student stu = it.next();
            System.out.println(stu);
        }

        //让工人按照姓名排序
        TreeSet<Worker> ts2 = new TreeSet<Worker>(new ComparatorByName());
        ts2.add(new Worker("abc",26));
        ts2.add(new Worker("aaa",29));
        ts2.add(new Worker("lisi",20));


        for (Iterator<Worker> it = ts2.iterator(); it.hasNext();) {
            Worker worker =  it.next();
            System.out.println(worker);

        }
    }
}

class ComparatorByName implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        int temp = o1.getName().compareTo(o2.getName());
        return temp == 0 ? o1.getAge()-o2.getAge() : temp;
    }
}
