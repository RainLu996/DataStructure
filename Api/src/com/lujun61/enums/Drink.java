package com.lujun61.enums;

import java.util.Scanner;

/*
    饮料厂举办一次促销优惠活动，乐羊羊C型饮料，凭3个瓶盖可以再换一瓶C型饮料，并且可以一直循环下去(但不允许暂借或赊账)。
    请你计算一下，如果小明不浪费瓶盖，尽可能地参加活动，那么，对于他初始买入的n瓶饮料最后他一共能喝到多少瓶饮料？

    输入：一个整数n，表示开始购买的饮料数量（0<n<10000）

    输出：一个整数，表示实际得到的饮料数
 */
public class Drink {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        int count = num;
        while (num >= 3) {
            num -= 3;
            count++;
            num++;
        }
        System.out.println(count);
    }
}
