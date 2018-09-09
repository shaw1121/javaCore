package com.siemens.mindsphere.io.c.bytestream.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Zhang Xiao
 * @date 9/8/2018 16:30
 */
public class CopyFileTest {

    public static void main(String[] args) throws IOException {

        /**
         * 复制文件
         * 读取一个已有的数据，并将这些读到的数据写入到另一个文件中
         */
        //1,明确源和目的。
        File srcFile = new File("d:\\template\\file.txt");
        File desFile = new File("d:\\template\\copy_file.txt");

        //2,明确字节流输入流和源相关联，输出流和目的关联。
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(desFile);

        //3, 使用输入流的读取方法读取字节，并将字节写入到目的中。
        int ch = 0;
        while ((ch = fis.read())!=-1){
            fos.write(ch);
        }

        fis.close();
        fos.close();
    }

}
