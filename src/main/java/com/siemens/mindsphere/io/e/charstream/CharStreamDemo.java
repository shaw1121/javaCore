package com.siemens.mindsphere.io.e.charstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Zhang Xiao
 * @date 9/15/2018 11:23
 */
public class CharStreamDemo {

  public static void main(String[] args) throws IOException {
      /**
       *
       * 需求1：通过流写一个篇文章，里面有中文。"你好你好"。indexOf('好');
       *
       * 需求2：一篇文章中出现了多少个好字。读取数据。判断好字并计数。
       * 思路：读取一个文本，获取内容判断好字。
       */

      writeCnText();

      readCNTextByReader();
  }

    private static void writeCnText() throws IOException {
        File file = new File("CNfile.txt");
        FileOutputStream fos = new FileOutputStream(file);
        String str = "a你好你好";
        fos.write(str.getBytes());
        fos.close();
    }

    public static void readCNTextByReader() throws IOException {

        //创建一个读取字符文件的读取流对象。FileReader。
        FileReader fr = new FileReader("tempfile\\cn.txt");//这个流的底层使用的是FileInputStream

        int ch = 0;
        int count = 0;
        while((ch=fr.read())!=-1){
            if(ch=='好'){
                count++;
            }
        }
        System.out.println("count="+count);
        fr.close();
    }
}
