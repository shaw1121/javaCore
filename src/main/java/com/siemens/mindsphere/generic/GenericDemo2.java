package com.siemens.mindsphere.generic;

import java.util.LinkedList;

/**
 * @author zhangxiao
 * @date 8/30/2018 21:53
 */
public class GenericDemo2 {

    public static void main(String[] args){
        Queue<String> queue = new Queue<String>();
        queue.myAdd("absd");
        queue.myAdd("ac");
        queue.myAdd("helloworld");

        while (!queue.isNull()){
            String obj = queue.myGet();
            System.out.println(obj);
        }
    }
}

//泛型类
class Queue<E>{
    //封装了一个链表数据结构。
    private LinkedList<E> link;
    /*
     * 队列初始化时，对链表对象初始化。
     */
    Queue(){
        link = new LinkedList<E>();
    }

    /**
     * 队列的添加元素功能。
     */
    public void myAdd(E obj){
        //内部使用的就是链表的方法。
        link.addFirst(obj);
    }

    /**
     * 队列的获取方法。
     */
    public E myGet(){
        return link.removeLast();
    }

    /**
     * 判断队列中元素是否空，没有元素就为true。
     */
    public boolean isNull(){
        return link.isEmpty();
    }
}
