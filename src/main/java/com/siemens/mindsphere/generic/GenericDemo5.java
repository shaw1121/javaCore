package com.siemens.mindsphere.generic;

import com.siemens.mindsphere.domain.Student;
//import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * @author Zhang Xiao
 * @date 8/31/2018 14:42
 */
public class GenericDemo5 {

    public static void main(String[] args){

        Set<Student> list = new HashSet<Student>();
        list.add(new Student("zhangsan1", 24));
        list.add(new Student("zhangsan2", 25));
        list.add(new Student("zhangsan3", 26));

        printList(list);

        List<String> list2 = new ArrayList<String>();
        list2.add("chengdu");
        list2.add("lasa");
        list2.add("ganzi");

        printList(list2);
    }

    /**
     * 当使用泛型类或者接口时，传递的具体的类型不确定，可以通过通配符(?)表示。
     * @param collection
     */
    private static void printList(Collection<?> collection) {
        for(Iterator<?> it = collection.iterator(); it.hasNext();){
            Object obj = it.next();
            System.out.println(obj);
        }
    }

}
