package com.siemens.mindsphere.io.d.test;

import com.siemens.mindsphere.domain.StudentForIOTest4;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Zhang Xiao
 * @date 9/14/2018 22:32
 */
public class Test4 {

    private static final String LIN_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {

        /**
         * 思路：
         * 1.描述学生
         * 2.用集合存储学生，treeset
         * 3. 新建文件，操作文件,持久化存储，涉及了IO技术。而且是将数据存储到文件中。所以写入。输出流。
         */
        StudentForIOTest4 student1 = new StudentForIOTest4("zhang", 23, 45, 66);
        StudentForIOTest4 student2 = new StudentForIOTest4("wang", 89, 55, 63);
        StudentForIOTest4 student3 = new StudentForIOTest4("xiao", 100, 450, 660);
        StudentForIOTest4 student4 = new StudentForIOTest4("yuan", 101, 150, 160);

        Set<StudentForIOTest4> set = new TreeSet<StudentForIOTest4>(Collections.reverseOrder());
        set.add(student1);
        set.add(student2);
        set.add(student3);
        set.add(student4);

        File dir = new File("tempt");
        if(!dir.exists()){
            dir.mkdir();
        }

        File destFile = new File(dir, "student_info.txt");
        write2File(set, destFile);

    }

    private static void write2File(Set<StudentForIOTest4> set, File destFile) throws IOException {

        //1, 创建输出流对象和目的文件关联。并创建目的文件。OutputStream操作文件 FileOutputStream。
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(destFile);

            //2,遍历集合中的对象数据。将数据写入到指定文件中。
            for (StudentForIOTest4 stu : set) {
                String info = stu.getName() + "\t" + stu.getSum() + LIN_SEPARATOR;

                //3,将数据写入到文件中。
                fos.write(info.getBytes());
            }
        }finally{
            if(fos!=null){
                try{
                    //关闭资源
                    fos.close();
                }catch (IOException e){
                    throw new RuntimeException("close failed");
                }
            }
        }
    }
}
