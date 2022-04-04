package com.lujun61.clac.t7;

public class 相乘 {
    public static void main(String[] args) {
        int a = 2021;
        long b = 1000000007;

        for (int i = 1; i < b; i++) {
            if ((i * b + 999999999) % a == 0) {
                System.out.println((i * b + 999999999) / a);
                break;
            }
        }
    }
}
