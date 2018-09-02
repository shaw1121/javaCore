package com.siemens.mindsphere.api.tools;

import java.util.Arrays;
import java.util.List;

/**
 * @author Zhang Xiao
 * @date 9/2/2018 09:38
 */
public class ArraysDemo {
    public static void main(String[] args){

        int[] arr = {34,21,67};
        System.out.println(Arrays.toString(arr));

        //将arr转成list集合。打印有问题？
        //如果数组中存储的是基本数据类型，那么转成集合，数组对象会作为集合中的元素存在。
        //如果数组中存储的是引用数据类型，转成集合，数组元素会作为集合元素存在
        List<int[]> list1 = Arrays.asList(arr);
        System.out.println(list1);
    }
}
