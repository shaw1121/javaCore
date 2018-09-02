package com.siemens.mindsphere.generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zhangxiao
 * @date 8/30/2018 23:42
 */
public class GenericDemo7 {

    public static void main(String[] args) {

        /*
         * 通配符? 在api中的体现。
         *
         * Collection接口： boolean containsAll(Collection<?> c)
         */

        Collection<String> c1 = new ArrayList<String>();
        c1.add("haha");
        c1.add("hehe");

        Collection<Integer> c2 = new ArrayList<Integer>();
        c2.add(4);
        c2.add(5);

        boolean b = c1.containsAll(c2);//了解 containsAll源码内判断是否包含的依据。依据是equals方法。
                                       //public  boolean equals(Object obj) "abc".equals(5);
        System.out.println("b="+b);
    }
}
