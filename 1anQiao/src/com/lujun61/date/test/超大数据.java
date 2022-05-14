package com.lujun61.date.test;

import java.io.IOException;
import java.util.Scanner;

public class 超大数据 {
    /*public static void main(String[] args) {
        BigInteger b1 = new BigInteger("223");
        BigInteger b2 = new BigInteger("224");

        System.out.println(b1.compareTo(b2));
    }*/

    public static void main(String[] args) throws IOException {
        Scanner buffs = new Scanner(System.in);
        char[] buff = buffs.next().toCharArray();



        int a = 0, b = 0, c = 0;
        for (int i = 0; i < buff.length; i++) {
            if (buff[i] >= 'a' && buff[i] <= 'z') b++;
            else if (buff[i] >= 'A' && buff[i] <= 'Z') a++;
            else if (buff[i] >= '0' && buff[i] <= '9') c++;
        }
        System.out.print(a + "\n" + b + "\n" + c);
    }
}
