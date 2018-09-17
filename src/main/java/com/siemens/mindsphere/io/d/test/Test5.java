package com.siemens.mindsphere.io.d.test;

import com.siemens.mindsphere.io.a.file.fileFilter.FileFilterBySuffix;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Xiao
 * @date 9/15/2018 09:19
 */
public class Test5 {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {
    /**
     * 建立一个java文件清单列表：获取指定目录下所有的.java文件(包含子目录中的)，并将这些java文件的绝对路径写入到一个文件中。
     *
     * <p>思路： 1.新建目的文件 2.获取指定目录下所有的.java文件，并将其写入到目的文件中
     */


        File dir = new File("D:\\study\\java\\javaCore\\src\\main\\java\\com\\siemens\\mindsphere");

        //定义过滤器，过滤.java文件
        FilenameFilter filter = new FileFilterBySuffix(".java");

        //目的目录及文件
        File desDir = new File("D:\\java_dir");
        if(!desDir.exists()){
            desDir.mkdir();
        }
        File java_file = new File(desDir, "java_file.txt");

        List<String> list = new ArrayList<String>();

        putName2List(list,filter, dir);

        writeJava2File(list, java_file);
    }

    /**
     * put java file name into list
     * @param list
     * @param filter
     * @param dir
     */
    private static void putName2List(List<String> list, FilenameFilter filter, File dir) {
        File[] files = dir.listFiles();

        for (File file : files) {

            if(file.isDirectory()){

                putName2List(list, filter, file);

            }else {
                //如果是文件，传递到过滤器中去过滤。将满足条件存储起来。
                if(filter.accept(file, file.getName())){
                    list.add(file.getAbsolutePath());
                }
            }
        }
    }

    /**
     * write list to file
     * @param list
     * @param java_file
     * @throws IOException
     */
    private static void writeJava2File(List<String> list, File java_file) throws IOException {

        //define
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try{
            fos = new FileOutputStream(java_file);
            bos = new BufferedOutputStream(fos);//带缓冲区的输出流，能够提高文件的写入效率

            for (String string: list) {
                String str_info = string + LINE_SEPARATOR;
                bos.write(str_info.getBytes());
                bos.flush();//每写一个绝对路径就刷新一次。
            }

        }finally{
            if(bos!=null){
                try{
                    fos.close();
                }catch (IOException e){
                    throw new RuntimeException("close fos failed");
                }
            }
        }
    }
}
