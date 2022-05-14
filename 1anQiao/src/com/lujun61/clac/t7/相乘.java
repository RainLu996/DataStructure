package com.lujun61.clac.t7;

public class 相乘 {
    public static void main(String[] args) {
        for (long i = 1; i < 1000000007; i++) {
            if ((i * 1000000007 + 999999999) % 2021 == 0) {
                System.out.println((i * 1000000007 + 999999999) / 2021);  //17812964
                break;
            }
        }
    }
}
