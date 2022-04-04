package com.lujun61.clac.t6;

public class 平方序列 {
    public static void main(String[] args) {
        for (int i = 2020; i < 100000 ; i++) {
            for (int j = i + 1; j < 100000 ; j++) {
                int a = 2019 * 2019;
                int b = i * i * 2;
                int c = j * j;
                /* 等差数列 */
                if (b == a + c) {
                    System.out.println(i + j);
                    return;
                }
            }
        }
    }
}
