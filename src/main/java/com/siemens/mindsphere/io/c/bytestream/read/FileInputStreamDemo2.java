package com.siemens.mindsphere.io.c.bytestream.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Zhang Xiao
 * @date 9/8/2018 17:50
 */
public class FileInputStreamDemo2 {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\study\\java\\javaCore\\src\\tempfile\\file.txt");

        FileInputStream fis = new FileInputStream(file);

        byte[] buffer = new byte[1024];

        int len = 0;
        while ((len=fis.read(buffer))!=-1){
            System.out.println(new String(buffer, 0, len));
        }

        fis.close();
    }

}
