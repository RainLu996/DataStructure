package com.lujun61.calendar.t4;

import java.util.Calendar;

public class 含2天数 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(1900, 0, 1);

        int count = 0;
        while (true) {
            if (c.get(Calendar.YEAR) == 9999 && c.get(Calendar.MONTH) == 11 && c.get(Calendar.DAY_OF_MONTH) == 31) break;
            int i1 = c.get(Calendar.YEAR);
            int i2 = c.get(Calendar.MONTH) + 1;
            int i3 = c.get(Calendar.DAY_OF_MONTH);

            String s1 = String.valueOf(i1);
            String s2 = String.valueOf(i2);
            String s3 = String.valueOf(i3);

            if (s1.contains("2") || s2.contains("2") || s3.contains("2")) {
                count++;
            }

            c.add(Calendar.DATE, 1);
        }
        System.out.println(count + 1);
    }
}
