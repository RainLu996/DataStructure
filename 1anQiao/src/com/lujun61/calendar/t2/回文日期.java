package com.lujun61.calendar.t2;

/*
    给定一个 8 位数的日期，请你计算该日期之后下一个回文日期和下一个 ABABBABA 型的回文日期各是哪一天。
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    输入描述
输入包含一个八位整数 N，表示日期。

对于所有评测用例，10000101 ≤ N ≤ 89991231，保证 N 是一个合法日期的 8 位数表示。

    输出描述
输出两行，每行 1 个八位数。第一行表示下一个回文日期，第二行表示下一个 ABABBABA 型的回文日期。
 */
public class 回文日期 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();

        String str = String.valueOf(data);
        String sYear = str.substring(0, 4);
        String sMonth = str.substring(4, 6);
        String sDay = str.substring(6, 8);
        int year = Integer.parseInt(sYear);
        int month = Integer.parseInt(sMonth);
        int day = Integer.parseInt(sDay);

/*
        for (int y = year; ; year++) {
            for (int i = 1; i <= 12; i++) {
                for (int j = 1; j <= 31; j++) {
                    if ()
                }
            }
        }*/


        System.out.println(isCircle(121));
    }

    public static boolean isCircle(int date) {
        String s = String.valueOf(date);
        StringBuilder st = new StringBuilder(s);
        String targets = st.reverse().toString();
        return s.equals(targets);
    }

    public static boolean isCirclePlus(int date) {
        String s = String.valueOf(date);
        StringBuilder st = new StringBuilder(s);
        String targets = st.reverse().toString();

        Map<Integer, Integer> m = new HashMap<>();
        return s.equals(targets);
    }
}
