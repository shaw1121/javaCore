package com.siemens.mindsphere.generic;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author zhangxiao
 * @date 8/30/2018 21:52
 */
public class GenericTest {

    public static void main(String[] args){
        /**
         * 创建一个由唯一性元素组成的集合，要求对元素按照长度排序。set -- treeset//按照长度排序，需要比较器。匿名内部类完成
         */
        TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int temp = o1.length() - o2.length();
                return temp == 0 ? o1.compareTo(o2) : temp;
            }
        });

        ts.add("absdd");
        ts.add("abs");
        ts.add("die");
        ts.add("cgu");

        for(Iterator<String> it = ts.iterator();it.hasNext();){
            String str = it.next();
      System.out.println(str);
        }
    }
}
