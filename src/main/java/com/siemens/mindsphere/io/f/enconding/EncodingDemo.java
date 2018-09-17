package com.siemens.mindsphere.io.f.enconding;

import java.io.UnsupportedEncodingException;

/**
 * @author Zhang Xiao
 * @date 9/16/2018 10:22
 */
public class EncodingDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String str = "你好";
        byte[] bytes = str.getBytes("utf-8");

        for (byte b : bytes) {
            System.out.println(b);
        }

        String s1 = new String(bytes, "utf-8");
        System.out.println(s1);
    }
}
