package com.siemens.mindsphere.io.g.buffer;

import java.io.IOException;
import java.io.Reader;

/**
 * @author Zhang Xiao
 * @date 9/16/2018 16:08
 */
public class MyBufferedReader {

    private Reader r;
    // 定义一个字符数组,作为缓冲区。
    private char[] buff = new char[1024];

    //定义一个索引
    private int index;

    //定义一个计数器
    private int count;

    //构造函数，需要一初始化就具备一个流对象
    MyBufferedReader(Reader r){
        this.r = r;
    }

    /**
     * 提供一个可以从缓冲区中读取一个字符的方法
     * @return
     * @throws IOException
     */
    public int read() throws IOException {

        //需要先通过流对象从底层设备上获取一定量的数据到缓冲区数组中，利用流对象read(char[]);
        //如果 count 记录字符的个数变为0，说明缓冲区已经没有字符数据
        if(count == 0){
            //从设备上获取一定量的数据存储到缓冲区，用 count记录存储字符的个数
            //read(char[] cbuf) Reads characters into an array.
            count = r.read(buff);

            //每取一次新的数据，将角标归为0
            index = 0;
        }

        // if count < 0, means reach 0, end of the file
        if(count == -1){
            return -1;
        }
        //从缓冲区中取出一个字符
        char ch = buff[index];

        //角标自增
        index++;
        //计数器自减
        count--;

        return ch;
    }

    public String readLine() throws IOException {

        StringBuilder sb = new StringBuilder();

        int ch;
        while ((ch=r.read())!=-1){
            if (ch == '\n') {
                continue;//遇到换行符，继续
            }

            if(ch == '\r'){
                return sb.toString();
            }

            sb.append((char)ch);
        }

        //万一文本中最后一行没有行终止符，判断一下sb中是否有内容，如果有则返回。
        if(sb.length()!=0){
            return sb.toString();
        }

        return null;
    }


    public void close() throws IOException {
        r.close();
    }
}
