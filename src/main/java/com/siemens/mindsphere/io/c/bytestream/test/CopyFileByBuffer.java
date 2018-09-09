package com.siemens.mindsphere.io.c.bytestream.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Zhang Xiao
 * @date 9/8/2018 16:52
 */
public class CopyFileByBuffer {

    public static void main(String[] args) throws IOException {

        // 1,明确源和目的。
        File srcFile = new File("d:\\siemens\\SAP\\youjia.mp4");
        File desFile = new File("d:\\siemens\\SAP\\copy_youjia.mp4");

        //2,明确字节流输入流和源相关联，输出流和目的关联。
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(desFile);

        byte[] buf = new byte[1024];

        //3, 使用输入流的读取方法读取字节，并将字节写入到目的中。
        int len = 0;
        while ((len = fis.read(buf))!=-1){
            fos.write(buf);
        }

        fis.close();
        fos.close();
    }

}
