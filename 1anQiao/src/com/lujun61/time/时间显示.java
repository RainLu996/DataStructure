package com.lujun61.time;


/*
    小蓝要和朋友合作开发一个时间显示的网站。在服务器上，朋友已经获取了当前的时间，用一个整数表示，
    值为从 1970 年 1 月 1 日 00:00:00 到当前时刻经过的毫秒数。现在，小蓝要在客户端显示出这个时间。
    小蓝不用显示出年月日，只需要显示出时分秒即可，毫秒也不用显示，直接舍去即可。
    给定一个用整数表示的时间，请将这个时间对应的时分秒输出。
 */
public class 时间显示 {
    public static void main(String[] args) {
        /*Scanner scan = new Scanner(System.in);
        long num = scan.nextLong();
        scan.close();*/

        long num = System.currentTimeMillis();

        long seconds = num / 1000;
        long second = seconds % 60;

        long minutes = seconds / 60;
        long minute = minutes % 60;

        long hours = minutes / 60;
        long hour = hours % 24;

        /**
         * 格式符'%02d'中 2d 前面的 前导符0 表示输出数据时，若左边 有多余位，则补0。
         */
        System.out.printf("%02d:%02d:%02d", hour, minute, second);
    }
}
