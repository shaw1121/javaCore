package com.siemens.mindsphere.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Zhang Xiao
 * @date 9/2/2018 23:08
 */



public class MapTest {

    public static void main(String[] args){
        String str = "werertrrrrtyuifgkiryuiop";
        String charAppearTime = getCharAppearTime(str);
        System.out.println(charAppearTime);
    }

  /**
   * "werertrtyuifgkiryuiop",获取字符串中每一个字母出现的次数 要求返回结果个格式是 a(1)b(2)d(4)......;
   *
   * <p>思路：
   * 1.将字母放在一个char[]数组里；
   * 2.遍历 数组,获取字符串中的每一个字母 *
   * 3，用字母去查表，如果查到了该字母对应的次数，就将这个次数+1后重新存回表中。 *
   * 如果没有查到呢？将该字母和1存到表中。
   * 4.每一字母都查完表后，表中记录的就是所有字母出现的次数。
   * 5.将map转为想要的格式
   *
   * @param str
   * @return
   */
  private static String getCharAppearTime(String str) {


      /*
        int len = str.length();
        char[] charArr = new char[len];
        for (int i=0; i < len; i++){
            charArr[i] = str.charAt(i);
        }*/

        //以上可用下行代替
        char[] charArr = str.toCharArray();

        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
        for (int i=0; i < charArr.length; i++){

            //判断,必须是字母
            if(!(charArr[i]>='a' && charArr[i]<='z' || charArr[i]>='A' && charArr[i]<='Z')){
                continue;
            }

            //4，将遍历到的字母作为键去查map这个表。获取对应的次数。
            Integer value = map.get(charArr[i]);

            //5，有可能要查询的字母在表中不存在对应的次数，需要判断。
            //如果返回是null，说明字母没有对应的次数。就将这个字母和1存储到表中。
            if(value == null){
                map.put(charArr[i], 1);
            }else {
                //否则，说明有对应的次数对次数自增。将字母和新的次数存储到表中。
                value++;
                map.put(charArr[i], value);
            }
        }

        return mapToString(map);

    }

    //转格式
    /*
     * 将map集合中的键值转成   格式是  a(1)b(2)d(4)......
     * map中有很多数据，无论是多少个，什么类型，最终都变成字符串。
     * StringBuffer 这个容器就符合这个需求。如果是单线程，建议使用StringBuilder。
     */
    private static String mapToString(Map<Character, Integer> map){

        StringBuilder sb = new StringBuilder();

        //获取key, value
//        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
//        Iterator<Map.Entry<Character, Integer>> it = entries.iterator();
//        while (it.hasNext()){
//            Map.Entry<Character, Integer> me = it.next();
//            Character key = me.getKey();
//            Integer value = me.getValue();
//
//            sb.append(key + "(" + value + ")");
//        }

        //以上，可用下列方式替代，更简洁
        for(Character key  : map.keySet()){
            Integer value = map.get(key);

            sb.append(key+"("+value+")");
        }

        return sb.toString();
    }
}
