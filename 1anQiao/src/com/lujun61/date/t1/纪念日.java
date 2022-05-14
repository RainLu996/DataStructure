package com.lujun61.date.t1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 纪念日 {
    public static void main(String[] args) throws ParseException {
        DateFormat format3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d = new Date();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = format.parse("1921-7-23 12:00:00");
        Date end = format.parse("2020-7-1 12:00:00");
        System.out.print((end.getTime() - start.getTime()) / 1000 / 60);
    }
}
