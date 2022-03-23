package com.lujun61.test;

import java.util.Arrays;

public class Test02 {
    public static void main(String[] args) {
        System.out.println(取后四位(12345));


        int[] array = {1, 2, 4, 2, 343, 3, 3, 334323};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static int 取后四位(int i) {
        return i % 10000;
    }
}
