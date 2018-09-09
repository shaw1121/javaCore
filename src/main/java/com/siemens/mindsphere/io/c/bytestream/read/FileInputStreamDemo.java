package com.siemens.mindsphere.io.c.bytestream.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Zhang Xiao
 * @date 9/8/2018 17:07
 */
public class FileInputStreamDemo {

    //需求：读取文件中的数据，显示在屏幕上。
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\study\\java\\javaCore\\src\\tempfile\\file.txt");

        //创建一个字节输入流对象,必须明确数据源，其实就是创建字节读取流和数据源相关联。
        FileInputStream fis = new FileInputStream(file);

        //读取数据。使用 read();一次读一个字节。
        int ch = 0;
        while ((ch=fis.read())!=-1){
            System.out.println((char)ch);
        }

//        int ch1 = fis.read();
//        System.out.println("ch1=" + (char)ch1);
//        int ch2 = fis.read();
//        System.out.println("ch1=" + (char)ch2);
//        int ch3 = fis.read();
//        System.out.println("ch1=" + (char)ch3);
//        int ch4 = fis.read();
//        System.out.println("ch1=" + (char)ch4);

        fis.close();//切记！！！
    }

}
