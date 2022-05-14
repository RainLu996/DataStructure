package com.lujun61.mod.t1;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * mod运算法则：
 * https://blog.csdn.net/mahoon411/article/details/105637663
 */
public class 八次求和 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        BigInteger count = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            count = count.add(new BigInteger(String.valueOf(i)).pow(8));
        }

        System.out.println(count.mod(new BigInteger("123456789")));
    }
}
