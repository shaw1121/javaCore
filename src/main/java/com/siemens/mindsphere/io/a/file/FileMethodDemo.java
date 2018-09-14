package com.siemens.mindsphere.io.a.file;

import com.siemens.mindsphere.io.a.file.fileFilter.FileFilterByDir;
import com.siemens.mindsphere.io.a.file.fileFilter.FileFilterBySuffix;
import java.io.File;

/**
 * @author Zhang Xiao
 * @date 9/9/2018 10:37
 */
public class FileMethodDemo {

    public static void main(String[] args){
        //取文件，自定义格式
        File dir = new File("d:\\siemens");

        File[] files = dir.listFiles(new FileFilterBySuffix(".pptx"));
        for (File file : files) {
            System.out.println("file: " + file.getName());
        }

        //取文件夹
        File[] dirs = dir.listFiles(new FileFilterByDir());
        for (File subdir : dirs) {
            System.out.println("dir: " + subdir.getName());
        }
    }
}
