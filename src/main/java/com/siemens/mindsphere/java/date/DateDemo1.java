package com.siemens.mindsphere.java.date;

import static java.util.Calendar.HOUR;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Zhang Xiao
 * @date 9/3/2018 20:55
 */
public class DateDemo1 {

    public static void main(String[] args){

        long time = System.currentTimeMillis();//current time
        Date date = new Date(time);

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        DateFormat dateFormat1 = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

        String str_date = dateFormat.format(date);
        String str_dateTime = dateFormat1.format(date);

        System.out.println(str_date);
        System.out.println(str_dateTime);

        //Calendar
        Calendar calendar = Calendar.getInstance();
        int weekYear = calendar.getWeekYear();
        TimeZone timeZone = calendar.getTimeZone();

//        final int DAY_OF_MONTH;
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int dayofMonth = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println(year + "年" + month + "月" + dayofMonth + "日");

    }
}
