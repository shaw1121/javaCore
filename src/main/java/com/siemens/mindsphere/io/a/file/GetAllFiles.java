package com.siemens.mindsphere.io.a.file;

import java.io.File;

/**
 * @author Zhang Xiao
 * @date 9/8/2018 23:55
 */
public class GetAllFiles {
    
    public static void main(String[] args){
    /**
     * 获取给定目录中的内容（包含子目录及文件）
     * 思路：
     * 1，在遍历当前目录时，会获取到当前的所有的文件以及文件夹，
     * 2，要遍历子目录需要对获取到的当前的file对象进行判断，只有是目录才可以作为子目录进行继续遍历。
     */
    File dir = new File("d:\\siemens");
        listAll(dir);
    }

    private static void listAll(File dir) {
        System.out.println("dir: " + dir);
        File[] files = dir.listFiles();
        for (File file : files) {

            if(file.isDirectory()){
                listAll(file);
            }else {
                System.out.println("file: " + file.getName());
            }
        }
    }

}
