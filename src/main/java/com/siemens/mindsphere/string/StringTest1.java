package com.siemens.mindsphere.string;

/**
 * @author Zhang Xiao
 * @date 8/31/2018 15:42
 */
public class StringTest1 {
    /**
     * 获取两个字符串的最大相同子串。 "asdfitcastghjfghjk" "xcitcastvbnm"
     * 思路：
     * 1.比较长度
     * 2.判断
     * @param args
     */
    public static void main(String [] args){
        String str1 = "asdfitcastghjfgsiemenshjk";
        String str2 = "xcitcastvbnsiemensm";

        String str = getMaxSubString(str1, str2);
        System.out.println(str);
    }

    private static String getMaxSubString(String str1, String str2){//静态上下文需要静态方法

        if(str1.length() == 0 || str2.length() == 0){
            return null;
        }

        String max, min;

        max = (str1.length()>str2.length()) ? str1: str2;
        min = max.equals(str1) ? str2: str1;

        if(max.contains(min)){
            return min;
        }

        for(int i = 0; i < min.length(); i++) {

//            for(int j = 0; j <= i; j++) {
//
//                String subStr = min.substring(j, min.length()-i-j);
//                if(max.contains(subStr)){
//                    return subStr;
//                }
//            }

            for(int start = 0, end = min.length()-i; end <= min.length(); start++, end++ ){
                String temp = min.substring(start, end);

                if(max.contains(temp)){
                    return temp;
                }
            }
        }

        return null;
    }
}
