package com.lujun61.time;

import java.util.Scanner;

/*
    现在时间是 a 点 b 分，请问 t 分钟后，是几点几分？
 */
public class 时间加法 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int t = s.nextInt();

        long allSeconds = a * 60L * 60 + b * 60L + t * 60L;

        long minutes = allSeconds / 60;
        long minute = minutes % 60;

        long hours = minutes / 60;
        long hour = hours % 24;

        System.out.printf("%02d:%02d", hour, minute);
    }
}
