package com.siemens.mindsphere.io.f.enconding;

import java.io.UnsupportedEncodingException;

/**
 * @author Zhang Xiao
 * @date 9/16/2018 10:30
 */
public class CutStringTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        //对字符串按照字节数截取，"abc你好" 有5个字符，有7个字节。
        //按照3个字节截取 abc ，按照四个字节截取 abc和你字的一半，如果出现中文一半舍弃。请定义一个功能解决这个问题。
        //思路：1.
        String str = "abc你好";
        String str_cut = cutString(str, 6);
        System.out.println(str_cut);
    }

    private static String cutString(String str, int i) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes("utf-8");
        int count = 0;

        for(int j=i-1; j<i; j++){
            if(bytes[j] < 0){
                count++;
            }else {
                break;
            }
        }

        if(count%2 == 0){
            return new String(bytes, 0, i);
        }else {
            return new String(bytes, 0, i-1);
        }


    }
}
