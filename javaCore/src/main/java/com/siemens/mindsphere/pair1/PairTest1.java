package com.siemens.mindsphere.pair1;

import javafx.util.Pair;

/**
 * Created by da5wwf
 * on 7/28/2018 17:02.
 */
public class PairTest1 {
    public static void main(String[] args){
        String[] words = {"mary", "had", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}

class ArrayAlg{
    public static Pair<String> minmax(String[] a){
        if(a==null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];
        for(int i = 1; i < a.length; i++){
            if(min.compareTo(a[i]) > 0) min = a[i];
            if(max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
    }
}
