package com.siemens.mindsphere.javaproperties;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by da5wwf
 * on 7/31/2018 20:09.
 */

//读取文件内容
public class ReadProperties {

    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/test.properties");
        prop.load(fis);
        prop.list(System.out);
        System.out.println("\n The baseURI property: " + prop.getProperty("baseURI"));
    }
}
