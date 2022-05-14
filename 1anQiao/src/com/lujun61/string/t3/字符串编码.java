package com.lujun61.string.t3;

import java.math.BigInteger;
import java.util.Scanner;


/*
    123242526

    LCXYZ
*/
public class 字符串编码 {
    static byte[] chars = { 0, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 };

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String code = s.next();

        int l = 0;
        int f = 1;
        while (f != code.length() + 1) {
            if (code.substring(l, f).length() < 2) {
                f++;
                continue;
            }
            if (new BigInteger(code.substring(l, f)).compareTo(new BigInteger("26")) > 0) {
                f--;
            }
            String ch = code.substring(l, f);
            int index = Integer.parseInt(ch);
            System.out.print((char) chars[index]);
            l = f;
            f++;
        }
    }
}
