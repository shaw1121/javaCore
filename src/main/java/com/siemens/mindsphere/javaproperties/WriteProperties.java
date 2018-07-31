package com.siemens.mindsphere.javaproperties;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

/**
 * Created by da5wwf
 * on 7/31/2018 20:21.
 *
 */

//通过list 方法将Properties写入Properties文件
//若文件存在，则会覆盖该文件
public class WriteProperties {

    public static void main(String[] args) {
        Properties pro = new Properties();
        pro.setProperty("id", "xiao");
        pro.setProperty("name", "zhang");

        try {
            PrintStream fw = new PrintStream(new File("D:\\study\\java\\javaCore\\src\\main\\resources\\test.properties"));
            pro.list(fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
