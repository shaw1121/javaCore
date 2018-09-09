package com.siemens.mindsphere.io.a.file;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zhang Xiao
 * @date 9/9/2018 00:13
 */
public class GetAllFilesByQueue {

    public static void main(String[] args){
    // 不用递归， 实现 获取给定目录中的内容（包含子目录及文件）
    /**
     * 思路：
     * 1，可以通过对每一个目录进行for循环，但是目录层级很多，for会死掉。 *
     * 2，每遍历到一个目录，不对其进行遍历，而是先临时存储起来。 相当于把所有目录（无论同级不同级）都存储起来。
     * 3，遍历容器时取到就是目录，然后对目录遍历即可。 *
     * 4，从容器中取到目录遍历时发现内部还有目录，一样将这些目录存储到容器中。
     * 5，只要不断的遍历这个容器就哦了。
     */
    File dir = new File("d:\\siemens");
        System.out.println(dir.getName());
        listAll(dir);

    }

    private static void listAll(File dir) {
        Queue<File> queue = new Queue<File>();

        // 1,对dir进行当前目录的遍历。
        File[] files = dir.listFiles();

        for (File file : files) {
            // 2, 如果有子目录，存储到队列中。
            if (file.isDirectory()){
//                System.out.println(file.getName());
                queue.myAdd(file);
            }else {
                System.out.println("file: " + file.getName());
            }
        }

        //3,遍历队列容器。因为子目录都在队列中。
        while (!queue.isNull()){
            File subDir = queue.myGet();//从队列中取出子目录。
            System.out.println("dir: " + subDir);

            File[] files1 = subDir.listFiles();

            //4,遍历子目录。
            for (File subFile : files1) {
                if(subFile.isDirectory()){
                    queue.myAdd(subFile); //如果子目录中还有子目录，继续存储到队列中。
                }else {
                    System.out.println("file: " + subFile.getName());
                }
            }

        }
    }

}

/**
 * 队列结构。先进先出。
 */
class Queue<E>{

    private LinkedList<E> link;//实现队列，堆栈，利用LinkedList

    /**
     * 提供了构造队列对象的构造器
     */
    public Queue(){
        link = new LinkedList<E>();
    }

    public void myAdd(E obj){
        link.addFirst(obj);
    }

    public E myGet(){
        return link.removeLast();
    }

    public boolean isNull(){
        return link.isEmpty();
    }
}
