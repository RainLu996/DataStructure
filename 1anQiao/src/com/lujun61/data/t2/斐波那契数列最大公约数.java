package com.lujun61.data.t2;

import java.math.BigInteger;

public class 斐波那契数列最大公约数 {
    public static void main(String[] args) {
        BigInteger i1 = BigInteger.ONE;
        BigInteger i2 = BigInteger.ONE;
        BigInteger i3 = BigInteger.ZERO;
        BigInteger i520 = BigInteger.ZERO;

        for (int i = 3; i <= 2020; i++) {
            i3 = i1.add(i2);
            i1 = i2;
            i2 = i3;
            if (i == 520) {
                i520 = i3;
            }
        }

        System.out.println(gcd(i3, i520));
    }

    private static BigInteger gcd(BigInteger i3, BigInteger i520) {
        return i520.compareTo(BigInteger.ZERO) == 0 ? i3 : gcd(i520, i3.mod(i520));
    }
}
