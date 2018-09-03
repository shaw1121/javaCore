package com.siemens.mindsphere.map;

import com.siemens.mindsphere.domain.StudentForMapTest2;
import java.util.HashMap;

/**
 * @author Zhang Xiao
 * @date 9/3/2018 18:52
 */
public class MapTest2 {

    public static void main(String[] args){
        HashMap<StudentForMapTest2, String> map = new HashMap<StudentForMapTest2, String>();

        map.put(new StudentForMapTest2("zhangsan", 23), "shanghai");
        map.put(new StudentForMapTest2("lisi", 21), "chengdu");
        map.put(new StudentForMapTest2("alan", 25), "hefei");
        map.put(new StudentForMapTest2("lisi", 21), "chengdu");

        for(StudentForMapTest2 key: map.keySet()){
            String value = map.get(key);
            System.out.println(key.toString() + "--->" + value);
        }

        //StudentForMapTest2 need override map.put要调用的方法：hashcode 和 equals 以及 compareTo()
    }
}
