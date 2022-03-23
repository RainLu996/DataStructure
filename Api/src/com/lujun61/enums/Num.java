package com.lujun61.enums;


/*
        题目：观察下面的现象，某个数字的平方，按位累加仍然等于自身

        1^3=1

        8^3=512        5+1+2=8

        17^3=4913      4+9+1+3=17

        ...

        请你计算包括1，8，17在内，符合这个性质的正整数一共有多少个？
*/
public class Num {
    public static void main(String[] args) {
        int num = 0;
        int count = 0;
        for (int i = 1; i < 100; i++) {
            num = i;
            num = num * num * num;
            int temp = 0;
            while (num > 0) {
                temp += num % 10;
                num /= 10;
            }
            if (temp == i) {
                count++;
            }
        }
        System.out.println(count);
    }
}
