package com.siemens.mindsphere.java.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * @author Zhang Xiao
 * @date 9/5/2018 22:19
 */
public class DateTest2 {

//    public static void main(String[] args) throws ParseException {
//        //"2013-4-25"到"2013年7月29日"到底有多少天
//        String str1 = "2013-4-25";
//        String str2 = "2013年7月29日";
//
//        int style_1 = DateFormat.MEDIUM;
//        int style_2 = DateFormat.LONG;
//
//        int days = getDays(str1, str2, style_1, style_2);
//        System.out.println(days);
//    }
//
//    private static int getDays(String str1, String str2, int style_1, int style_2) throws ParseException {
//
//        DateFormat dateFormat1 = DateFormat.getDateInstance(style_1);
//        DateFormat dateFormat2 = DateFormat.getDateInstance(style_2);
//
//        Date date1 = dateFormat1.parse(str1);
//        Date date2 = dateFormat2.parse(str2);
//
//        long time1 = date1.getTime();
//        long time2 = date2.getTime();
//
//        long milliseconds = Math.abs(time1-time2);
//        int oneDay = 1000*60*60*24;
//
//        int days = (int) ((milliseconds)/oneDay);
//
//        return days;
//    }


    public static void main(String[] args) throws ParseException {
//		练习3,"2013-4-25"到"2013年7月29日"到底有多少天？
        /*
         * 思路：
         * 1，到底有多少天？相减的过程。
         * 2，字符串也不能相减啊，毫秒值可以相减。
         * 3，怎么获取毫秒值呢？毫秒值-->日期对象， 日期对象-->毫秒值。
         * 4，怎么获取日期对象呢？需要将字符串文本--解析-->日期对象。
         */

        String str_date1 = "2013-04-25";
        String str_date2 = "2013年7月29日";
        //需要定义两个模式。一个解析str_date1,一个解析str_date2。
        int style_1 = DateFormat.MEDIUM;//默认风格。
        int style_2 = DateFormat.LONG;//默认风格。

        int days = getDays(str_date1,str_date2,	style_1,style_2);
        System.out.println("days="+days);
    }

    private static int getDays(String str_date1, String str_date2,
            int style_1, int style_2) throws ParseException {

        //1，根据给定风格创建格式器对象。
        DateFormat format_1 = DateFormat.getDateInstance(style_1);
        DateFormat format_2 = DateFormat.getDateInstance(style_2);

        //2,对文本进行解析。
        Date date_1 = format_1.parse(str_date1);
        Date date_2 = format_2.parse(str_date2);

        //3,获取日期对象毫秒值。
        long time_1 = date_1.getTime();
        long time_2 = date_2.getTime();

        //4,相减。
        long time = Math.abs(time_1 - time_2);
//		System.out.println(time);
        int day = (int)(time/1000/60/60/24);
        return day;
    }

}
