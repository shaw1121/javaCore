package com.siemens.mindsphere.generic;

/**
 * @author Zhang Xiao
 * @date 8/31/2018 14:20
 */
public class GenericDemo3 {
    public static void main(String[] args){

        Util<String> util = new Util<String>();
        util.show("nihao");
        Util.print(3);
    }
}

class Util<W>{

    //当方法要操作的类型（不确定）和类上的泛型不一定一致，这时可以将泛型定义在方法上
    public <Q> void show(Q q){
        System.out.println("show: " + q);
    }

    //如果方法是静态，需要使用泛型，那么泛型必须定义在方法上
    public static <E> void print(E e){
        System.out.println("print: " + e);
    }

    public void method(W w){

    }
}
