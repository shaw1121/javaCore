package com.siemens.mindsphere.generic;

import com.siemens.mindsphere.domain.Person;
import com.siemens.mindsphere.domain.Student;
import com.siemens.mindsphere.domain.Worker;

import java.util.*;

/**
 * @author Zhang Xiao
 * @date 8/31/2018 15:16
 */
public class GenericDemo6 {

    public static void main(String[] args){

        Set<Student> list = new HashSet<Student>();
        list.add(new Student("zhangsan1", 24));
        list.add(new Student("zhangsan2", 25));
        list.add(new Student("zhangsan3", 26));

        printList(list);

        List<Worker> list2 = new ArrayList<Worker>();
        list2.add(new Worker("lisi1",31));
        list2.add(new Worker("lisi2", 32));
        list2.add(new Worker("lisi3", 33));

        printList(list2);
    }

  /**
   * 如果想要对被打印的集合中的元素类型进行限制，只在指定的一些类型，进行打印
   * 使用泛型限定
   * 只需要打印学生和工人的集合。找到学生和工人的共性类型Person
   * ? extends Person : 接收Person类型或者Person的子类型
   * 总结：
   * ? super E:接收E类型或者E的父类型。下限。
   * ? extends E:接收E类型或者E的子类型。上限。
   * @param collection
   */
  private static void printList(Collection<? extends Person> collection) {
        for(Iterator<? extends Person> it = collection.iterator(); it.hasNext();){
            Person p = it.next();
            System.out.println(p);
        }
    }
}
