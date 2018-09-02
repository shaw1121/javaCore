package com.siemens.mindsphere.map;

import com.siemens.mindsphere.domain.Student;
import com.siemens.mindsphere.comparator.ComparatorByName;

import java.util.Map;
import java.util.TreeMap;
import com.siemens.mindsphere.comparator.*;

/**
 * @author Zhang Xiao
 * @date 9/2/2018 23:03
 */
public class TreeMapTest {

    public static void main(String[] args) {
        /*
         * 练习二： 学生对象(姓名，年龄)都有自己的归属地，既然有对应关系。 将学生对象和归属地存储到map集合中。
         * 注意：同姓名同年龄视为重复的键。 按照学生的年龄进行从小到大的排序。 TreeMap。
         *
         * 如果要对学生按照姓名排序呢？
         */

        // 1,创建TreeMap集合对象。
        Map<Student, String> map = new TreeMap<Student, String>(new ComparatorByName());

        // 2,添加元素。
        map.put(new Student("lisi", 28), "上海");
        map.put(new Student("wangwu", 22), "北京");
        map.put(new Student("zhaoliu", 24), "成都");
        map.put(new Student("zhouqi", 25), "广州");
        map.put(new Student("wangwu", 22), "南京");

        //3,取出所有元素，entrySet()
        for(Map.Entry<Student, String> me : map.entrySet()){

            Student key = me.getKey();
            String value = me.getValue();

            System.out.println(key+"::"+value);

        }

    }
}
