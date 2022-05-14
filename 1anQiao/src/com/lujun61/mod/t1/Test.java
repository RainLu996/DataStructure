package com.lujun61.mod.t1;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        BigInteger i = new BigInteger("2");

        System.out.println(i.pow(10));

        BigInteger b = new BigInteger("2");

        BigInteger add = b.add(b);
        b.add(b);
        b.add(b);

        System.out.println(add);
    }
}
