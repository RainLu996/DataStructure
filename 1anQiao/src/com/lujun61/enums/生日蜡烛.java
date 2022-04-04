package com.lujun61.enums;


/*
    某君从某年开始每年都举办一次生日party，并且每次都要吹熄与年龄相同根数的蜡烛。

    现在算起来，他一共吹熄了236根蜡烛。

    请问，他从多少岁开始过生日party的？
 */
public class 生日蜡烛 {
    public static void main(String[] args) {
        System.out.println( ((float)6 + ((float)8/3) + ((float)952/714)));
        for (int i = 1; i < 45; i++) {
            int count = 0;
            for (int j = i; j < 100; j++) {
                count += j;
                if (count == 236) System.out.println(i);
            }
        }
    }
}
