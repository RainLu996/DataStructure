package com.lujun61.clac.t8;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int i = 23;
        int j = 10;
        String s1 = "" + i + j;
        Arrays.sort(s1.toCharArray());


        System.out.println(String.valueOf(s1));
    }
}
