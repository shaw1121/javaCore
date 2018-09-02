package com.siemens.mindsphere.test;

/**
 * Created by da5wwf
 * on 8/28/2018 09:59.
 */
public class MixDemo {

    public static void main(String[] args){
        String paramFile = ".//test-input/property/ps0001/testparam.properties";
        String outputDir = paramFile.split("/")[4];
        System.out.println(outputDir);
    }
}
