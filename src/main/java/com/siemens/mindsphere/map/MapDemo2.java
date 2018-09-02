package com.siemens.mindsphere.map;

import java.util.*;

/**
 * @author Zhang Xiao
 * @date 9/2/2018 22:49
 */
public class MapDemo2 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("星期一", "Monday");
        map.put("星期日", "Sunday");

        System.out.println("------------keySet方法的获取---------------");
//		System.out.println(map.get("星期一"));
        //怎么获取到所有的键呢？既然是所有的键，应该是一个集合，而且是一个单列集合。
        //list还是set呢？应该是set，因为map集合中键需要保证唯一性。
        //找到一个方法   Set<k> keySet();获取map集合中的键的set集合。
        Set<String> keySet = map.keySet();
        for(Iterator<String> it= keySet.iterator(); it.hasNext() ; ){
            String key = it.next();
            String value = map.get(key);//通过键获取对应的值。
            System.out.println(key+"::"+value);
        }
        //使用foreach循环，进行遍历。
        for(String key : keySet){
            System.out.println(key+":::::"+map.get(key));
        }

        System.out.println("-----------entrySet方法获取----------------");

        /*
         * Set entrySet():将map集合中映射关系存储到了Set集合中.
         * 映射关系：其实就是指键和值的对应关系。其实就是夫妻的结婚证。
         * 映射关系是什么类型的呢？  Map.Entry
         */
        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, String>> it = entrySet.iterator();
        //遍历Set中的映射关系对象。
        while(it.hasNext()){
            Map.Entry<String, String> me = it.next();//取到了映射关系对象。
            //获取键。
            String key = me.getKey();
            //获取值。
            String value = me.getValue();
            System.out.println(key+"-----"+value);
        }

        /*
         * 总结：map集合没有迭代器，取出元素的方式：将map集合转成单列结合，在使用单列集合的迭代器就可以了。
         * map集合也不能直接被foreach循环遍历。
         */
        for(Map.Entry<String,String> me : map.entrySet()){
            String key = me.getKey();
            //获取值。
            String value = me.getValue();
            System.out.println(key+"--------"+value);
        }


        System.out.println("-----------获取所有值的方法 values()----------------");
        /*
         * 获取所有的值，因为值不需要保证唯一性。所以返回类型时Collection。
         * 姓名--归属地。对应关系，获取所有的归属地。values();
         */

        //所有的英文星期。
        Collection<String> values = map.values();
        for(String value : values){
            System.out.println("value:"+value);
        }
    }
}

//interface MyMap{
//	public static interface MyEntry{}//内部接口。
//}

