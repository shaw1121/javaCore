package com.siemens.mindsphere.io.d.test;

import java.io.File;

/**
 * @author Zhang Xiao
 * @date 9/14/2018 22:13
 */
public class Test2 {

    public static void main(String[] args){
        //删除文件夹（含有文件及子文件夹）
        File dir = new File("d:\\test");
        
        removeDir(dir);
    }

    /**
     * 删除一个目录
     * @param dir
     */
    private static void removeDir(File dir) {

        // 1,列出当前目录下的文件以及文件夹File[]
        File[] files = dir.listFiles();

        //如果目录是系统级文件夹，java没有访问权限，会返回null数组，最好加入判断
        if(files != null){

            for (File file : files) {
                if(file.isDirectory()){
                    removeDir(file);
                }
                System.out.println(file + ":" + file.delete()); // 删除文件。用打印语句验证是否删除成功，是否出现了误删操作。
            }
        }

        System.out.println("dir: " + dir.delete());
    }

}
