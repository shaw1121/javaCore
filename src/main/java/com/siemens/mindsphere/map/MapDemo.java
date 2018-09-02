package com.siemens.mindsphere.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhang Xiao
 * @date 9/2/2018 22:46
 */
public class MapDemo {

    public static void main(String[] args) {

        /*
         * 存储中英文星期。
         * 使用map集合。
         */
        Map<String,String> map = new HashMap<String,String>();


        //添加元素。
        System.out.println(map.put("星期一", "Monday"));
//		System.out.println(map.put("星期一", "Mon"));//如果键相同，值覆盖。并put方法会返回旧值。如果没有旧值就null。
        //....
        map.put("星期日", "Sunday");


        //通过给定键获取值。
        String value = map.get("星期二");//如果键 不存在，返回null，通过此判断键的是否存在。
        System.out.println("value="+value);

        //删除元素。根据键删除。
        String s = map.remove("星期一");//获取给定键对应的值，并将该键值对从map集合删除。
        System.out.println("s="+s);


        System.out.println(map);
    }
}
