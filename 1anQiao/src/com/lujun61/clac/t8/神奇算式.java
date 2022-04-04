package com.lujun61.clac.t8;

import java.util.Arrays;

public class 神奇算式 {
    public static void main(String[] args) {
        int count = 0;

        for (int i = 1; i <  8; i++) {
            for (int j = 1; j < 1000000 ; j++) {
                int temp = i * j;
                String s1 = "" + i + j;
                char[] s2 = s1.toCharArray();
                Arrays.sort(s2);
                String s3 = String.valueOf(s2);

                String s4 = String.valueOf(temp);
                char[] s5 = s4.toCharArray();
                Arrays.sort(s5);
                String s6 = String.valueOf(s5);

                if (s4.equals(s6)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
