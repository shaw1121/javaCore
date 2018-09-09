package com.siemens.mindsphere.java.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Zhang Xiao
 * @date 9/5/2018 17:59
 */
public class DateTest {

    public static void main(String[] args) throws ParseException {

        //文本--->日期对象：解析。
//        String str_date = "2012-3-17";
//        DateFormat dateFormat = DateFormat.getDateInstance();
//        Date date = dateFormat.parse(str_date);
//
//        System.out.println(date);

        String str_date2 = "2013/3/17 17--13--45";
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd hh--mm--ss");
        Date date2 = dateFormat2.parse(str_date2);
        System.out.println(date2);
    }
}
