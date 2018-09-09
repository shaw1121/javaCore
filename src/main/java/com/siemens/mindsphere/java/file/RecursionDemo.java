package com.siemens.mindsphere.java.file;

/**
 * @author Zhang Xiao
 * @date 9/6/2018 21:44
 */
public class RecursionDemo {

    public static void main(String[] args) {
        //
        int sum = getSum(10000);
        System.out.println(sum);
    }

    private static int getSum(int num) {

        if(num == 1){
            return 1;
        }
        return num + getSum(num-1);
    }
}
