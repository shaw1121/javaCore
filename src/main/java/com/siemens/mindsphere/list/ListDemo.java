package com.siemens.mindsphere.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by da5wwf
 * on 8/28/2018 19:17.
 * 在list集合迭代元素中，对元素进行判断，一旦条件满足就添加一个新元素。
 * 会不会有问题？如果有？原因是什么？怎么解决？
 */
public class ListDemo {
    public static void main(String[] args){

        List list = new ArrayList();

        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test2");
        list.add("test3");
        list.add("test2");

        getSingleElement(list);

        System.out.println(list);
    }

    public static void getSingleElement(List list){
        List temp = new ArrayList();

//        Iterator it = list.iterator();
//        while (it.hasNext()){
//
//            if(!temp.contains(it.next()))
//                temp.add(it.next());
//        }

        for(Iterator it = list.iterator(); it.hasNext();){

            Object obj = it.next();

            if(!temp.contains(obj))
                temp.add(obj);
        }
        list.clear();
        list.addAll(temp);
    }
}
