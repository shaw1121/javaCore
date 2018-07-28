package com.siemens.mindsphere.statckTrace;

import java.util.Scanner;

/**
 * Created by da5wwf
 * on 7/28/2018 11:03.
 */
public class StackTrace {
    public static int factorial(int n){
        System.out.println("factorial(" + n + "):");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for(StackTraceElement f: frames)
            System.out.println(f);

        int r;
        if( n <= 1){
            r = 1;
        } else {
            r = n * factorial(n-1);
            System.out.println("return " + r);
        }

        return r;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = in.nextInt();
        factorial(n);
    }
}
