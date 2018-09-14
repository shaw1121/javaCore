package com.siemens.mindsphere.java.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Zhang Xiao
 * @date 9/5/2018 22:19
 */
public class DateMyTest {


    public static void main(String[] args) throws ParseException {
//		练习3,"2015-11-21 16:00:00"到"2018-09-14 15:59:59"有多少天？
        /*
         * 思路：
         * 1，到底有多少天？相减的过程。
         * 2，字符串也不能相减啊，毫秒值可以相减。
         * 3，怎么获取毫秒值呢？毫秒值-->日期对象， 日期对象-->毫秒值。
         * 4，怎么获取日期对象呢？需要将字符串文本--解析-->日期对象。
         */

        String str_date1 = "2015-11-21 16:00:00";
        String str_date2 = "2018-09-14 15:59:59";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        int days = getDays(str_date1,str_date2,	simpleDateFormat);
        System.out.println("days="+days);
    }

    private static int getDays(String str_date1, String str_date2,
            SimpleDateFormat simpleDateFormat) throws ParseException {

        //2,对文本进行解析。
        Date date1 = simpleDateFormat.parse(str_date1);
        Date date2 = simpleDateFormat.parse(str_date2);

        //3,获取日期对象毫秒值。
        long time_1 = date1.getTime();
        long time_2 = date2.getTime();

        //4,相减。
        long time = Math.abs(time_1 - time_2);
//		System.out.println(time);
        int day = (int)(time/1000/60/60/24);
        return day;
    }

}
