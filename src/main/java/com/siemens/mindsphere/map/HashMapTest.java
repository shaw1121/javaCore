package com.siemens.mindsphere.map;

import com.siemens.mindsphere.domain.Student;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhang Xiao
 * @date 9/2/2018 23:02
 */
public class HashMapTest {

    public static void main(String[] args) {

        /*
         * 练习一：
         * 学生对象(姓名，年龄)都有自己的归属地，既然有对应关系。
         * 将学生对象和归属地存储到map集合中。
         * 注意：同姓名同年龄视为重复的键。
         */

        //1,创建hashmap集合对象。
        Map<Student,String> map = new HashMap<Student,String>();

        //2,添加元素。
        map.put(new Student("lisi",28), "上海");
        map.put(new Student("wangwu",22), "北京");
        map.put(new Student("zhaoliu",24), "成都");
        map.put(new Student("zhouqi",25), "广州");
        map.put(new Student("wangwu",22), "南京");

        //3,取出元素。keySet  entrySet
//		Set<Student> keySet = map.keySet();
//		for(Student key : keySet){}
        for(Student key : map.keySet()){
            String value = map.get(key);

            System.out.println(key.toString()+"....."+value);
        }

    }
}
