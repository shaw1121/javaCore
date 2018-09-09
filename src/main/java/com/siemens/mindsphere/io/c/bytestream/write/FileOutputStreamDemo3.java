package com.siemens.mindsphere.io.c.bytestream.write;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Zhang Xiao
 * @date 9/8/2018 18:33
 */
public class FileOutputStreamDemo3 {

    public static void main(String[] args) {

        //异常处理：文件不存在时
        File file = new File("k:\\file.txt");
        FileOutputStream fos = null;// 变量放在try外面，之后语句块都可以使用
        try {
            fos = new FileOutputStream(file);//FileNotFoundException抛出
            fos.write("abcde".getBytes());

        } catch (IOException e) {
            System.out.println(e.toString() + "----");
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException("");
                }
            }

        }

    }

}
