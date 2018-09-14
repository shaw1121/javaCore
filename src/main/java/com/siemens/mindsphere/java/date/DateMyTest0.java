package com.siemens.mindsphere.java.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Zhang Xiao
 * @date 9/5/2018 22:19
 */
public class DateMyTest0 {


    public static void main(String[] args) throws ParseException {
//		练习3,"2015-11-21 16:00:00"后90天是几月几日？
        /**
         * 思路：
         * 1，2015-11-21 16:00:00、90天都转成毫秒
         * 2. 毫秒相加，然后再解析毫秒成日期
         */

        String str_date1 = "2030-09-16T00:00:00.005+08:00";
        int interval = 90;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+08:00");

        String str_date2 = getDateAfeterInterval(str_date1, simpleDateFormat, interval);

        System.out.println("date: "+str_date2);
    }

    private static String getDateAfeterInterval(String str_date1, SimpleDateFormat simpleDateFormat, int interval) throws ParseException {

        Date date1 = simpleDateFormat.parse(str_date1);
        long time1 = date1.getTime();

        long interval_ms = (long)interval*24*60*60*1000;

        long time2 = time1 +interval_ms;

        Date date2 = new Date(time2);

        String str_date2 = simpleDateFormat.format(date2);

        return str_date2;
    }

}
