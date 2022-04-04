package com.lujun61.calendar.t1;

import java.util.Calendar;


/**
 * Calendar类中的常量注意点：
 * 从星期天~星期六：1~7
 * 从一月~十二月：0~11
 */
public class CalendarTest {
    public static void main(String[] args) {
        跑步锻炼();

        世界末日();

        星期一();

        猜生日();
    }

    /*
        小蓝每天都锻炼身体。

正常情况下，小蓝每天跑 1 千米。如果某天是周一或者月初（1日），为了激励自己，小蓝要跑 2 千米。如果同时是周一或月初，小蓝也是跑 2 千米。
小蓝跑步已经坚持了很长时间，从 2000 年 1 月 1 日周六（含）到 2020 年 10 月 1 日周四（含）。请问这段时间小蓝总共跑步多少千米？
     */
    public static void 跑步锻炼() {
        int count = 0;
        Calendar c = Calendar.getInstance();
        c.set(2000, 0, 1);  //设置初始时间条件
        while (true) {
            //计数条件
            if (c.get(Calendar.DAY_OF_MONTH) == 1 || c.get(Calendar.DAY_OF_WEEK) == 2) count += 2;
            else count++;
            //终止条件
            if (c.get(Calendar.YEAR) == 2020 && c.get(Calendar.MONTH) == 9 && c.get(Calendar.DAY_OF_MONTH) == 1) break;
            c.add(Calendar.DATE, 1);
        }
        System.out.println(count);
    }


    /*
        1999年12月31日是星期五，
        请问：未来哪一个离我们最近的一个世纪末年(即XX99年)的12月31日正好是星期天（即星期日）？回答年份即可。
     */
    public static void 世界末日() {
        Calendar c1 = Calendar.getInstance();  //获取当前系统日历信息

        for (int year = 1999; year < 10000; year += 100) {
/*            c1.set(Calendar.YEAR, year);
            c1.set(Calendar.MONTH, 11);   //在API中，0~11代表1~12月
            c1.set(Calendar.DATE, 31);*/

            c1.set(year, 11, 31);

            /* 解释就是：1999年的 */
            if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                System.out.println(year);  //2299
                break;
            }
        }
    }

    /*
        整个 20 世纪（1901 年 1 月 1 日至 2000 年 12 月 31 日之间），一共有多少个星期一？
     */
    public static void 星期一() {
        int count = 0;
        Calendar c = Calendar.getInstance();
        c.set(1901, 0, 1);
        while (true) {
            if (c.get(Calendar.DAY_OF_WEEK) == 2) count++;
            if (c.get(Calendar.YEAR) == 2000 && c.get(Calendar.MONTH) == 11 && c.get(Calendar.DAY_OF_MONTH) == 31) break;
            c.add(Calendar.DATE, 1);
        }
        System.out.println(count);
    }


    /*
        今年的植树节（2012 年 3 月 12 日），小明和他的叔叔还有小伙伴们一起去植树。
        休息的时候，小明的同学问他叔叔多大年纪，他叔叔说：“我说个题目，看你们谁先猜出来！”

        “把我出生的年月日连起来拼成一个 8位数（月、日不足两位前补 0）正好可以被今天的年、月、日整除！”

        他想了想，又补充到：“再给个提示，我是 6 月出生的。”

        根据这些信息，请你帮小明算一下，他叔叔的出生年月日。


        格式是年月日连成的 8 位数。例如，如果是 1948 年 6 月 12 日，就写：19480612。
     */
    public static void 猜生日() {
        for (int i = 1900; i < 2012; i++) {
            for (int j = 1; j < 31; j++) {
                int date = i * 10000 + 600 + j;
                if (date % 2012 == 0 && date % 12 == 0) {
                    System.out.println(date);
                    break;
                }
            }
        }
    }
}
