package com.lujun61.string.t3;

import java.math.BigInteger;

public class Test {
    static byte[] chars = { 0, 'A', 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 };

    public static void main(String[] args) {
        String s = "sfsd";

        System.out.println(s.substring(0, 1));  //s


        System.out.println(new BigInteger("23").compareTo(new BigInteger("21")));


        /* 必须要强转为char才能输出对应字符 */
        System.out.println((char) chars[1]);

    }
}
