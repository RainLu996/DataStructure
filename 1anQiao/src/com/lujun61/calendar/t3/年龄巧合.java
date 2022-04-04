package com.lujun61.calendar.t3;

/*
    小明和他的表弟一起去看电影，有人问他们的年龄。小明说：今年是我们的幸运年啊。
    我出生年份的四位数字加起来刚好是我的年龄。表弟的也是如此。已知今年是 2014 年，并且，小明说的年龄指的是周岁。
    请推断并填写出小明的出生年份。
 */
public class 年龄巧合 {
    public static void main(String[] args) {

        for (int i = 1900; i < 2014; i++) {
            int age = 0;
            String s1 = String.valueOf(i);
            int t2 = i;
            for (int j = 0; j < s1.length(); j++) {
                int t1 = t2 % 10;
                t2 /= 10;

                age += t1;
            }
            if (age == 2014 - i) {
                System.out.println(i);
                break;
            }
        }
    }
}
