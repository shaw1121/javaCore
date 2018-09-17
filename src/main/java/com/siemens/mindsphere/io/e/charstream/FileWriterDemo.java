package com.siemens.mindsphere.io.e.charstream;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Zhang Xiao
 * @date 9/15/2018 20:24
 */
public class FileWriterDemo {
    
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("tempfile\\fw.txt");

        fw.write("你好，谢谢再见");
        fw.flush();
        fw.close();
    }
}
