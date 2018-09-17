package com.siemens.mindsphere.io.g.buffer;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author Zhang Xiao
 * @date 9/16/2018 17:00
 */
public class MyBufferedReaderDemo {

    public static void main(String[] args) throws IOException {
        //test self-defined buffered reader
        MyBufferedReader mbr = new MyBufferedReader(new FileReader("tempfile\\fw.txt"));

        String line = null;
        while ((line = mbr.readLine())!=null){
            System.out.println(line);
        }
        mbr.close();
    }
}
