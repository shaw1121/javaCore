package com.siemens.mindsphere.generic;

import com.siemens.mindsphere.domain.Student;

import java.util.*;

/**
 * @author Zhang Xiao
 * @date 9/2/2018 21:02
 */
public class GenericTest2 {

    public static void main(String[] args){
        /**
         * 案例：获取集合中元素的最大值。
         * 思路：
         * 1.将集合中的任一元素作为初始最大值
         * 2.遍历集合元素，并与初始最大值作比较
         * 3.大值赋给初始最大值
         * 4.返回最大值
         */
        TreeSet<Student> ts = new TreeSet<Student>();

        ts.add(new Student("cbddd", 22));
        ts.add(new Student("bangyuan", 32));
        ts.add(new Student("asbdjgugug", 23));

        Student max = getMax(ts);
        System.out.println(max);

        Collection<String> c2 = new ArrayList<String>();
        c2.add("abcd");
        c2.add("java");
        c2.add("z");
        c2.add("nba");
        String s = getMax(c2);
        System.out.println("s="+s);

        Collection<Dog> c3 = new ArrayList<Dog>();
//		getMax(c3);//已经做了限定，说明传递的集合中的元素类型必须是Comparable的子类。否则编译失败。
    }

    //这个功能虽然实现，但是有局限性，因为这个功能只能对存储了Student对象的集合进行最大值的获取。
    /*private static Student getMax(Collection<Student> coll){
        Iterator<Student> it = coll.iterator();
        Student max = it.next();
        while (it.hasNext()){
            if(max.compareTo(it.next())<0){
                max = it.next();
            }
        }
        return max;
    }

    //不加泛型时，无法明确集合中的元素时什么类型，为了便于操作用Object
    public static Object getMax(Collection c1) {

        // 1,定义变量，记录集合中任意一个元素，Collection集合取出元素的方式只有迭代器。
        Iterator it = c1.iterator();
        Object max = it.next();

        // 2,遍历容器。
        while (it.hasNext()) {
            Object o = it.next();
            Comparable temp = (Comparable)o;

            if (temp.compareTo(max) > 0) {
                max = temp;
            }
        }
        return max;
    }*/

    // 升级版, 重点掌握。要操作的元素的类型确定不？不确定。使用泛型限定。getMax方法接收的集合中的元素无论是什么类型，必须具备自然排序，必须是Comparable的子类。
    //Comparable<? super T> 既可以用Student接收，也可以用父类Person接收
    public static <T extends Comparable<? super T>> T getMax(Collection<? extends T> c){
        Iterator<? extends T> it = c.iterator();
        T max = it.next();

        while (it.hasNext()){
            T temp = it.next();
            if(temp.compareTo(max)>0){
                max = temp;
            }
        }
        return max;
    }


    //升升级版，改编自Collections.max()源码
    public static <T extends Comparable<? super T>> T getMax(Collection<? extends T> c, Comparator<? super T> comp){

        if(comp==null){
            return getMax(c);
        }

        Iterator<? extends T> it = c.iterator();

        T max = it.next();

        while(it.hasNext()){

            T temp = it.next();

            if(comp.compare(temp, max)>0){
                max = temp;
            }
        }

        return max;
    }
}


//Dog 未实现 Comparable接口
class Dog{

        }