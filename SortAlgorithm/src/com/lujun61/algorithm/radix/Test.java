package com.lujun61.algorithm.radix;


import java.util.Arrays;

/**
 * @param null
 * @return void
 * @description 
 * @author Jun Lu
 * @date 2021-08-16 22:28:39
 */
public class Test {
    public static void main(String[] args) {
        //使用工具类遍历二维数组
        int[][] test = new int[12][12];
        System.out.println("length = " + test.length);
        test[1][1] = 1;
        System.out.println("length = " + test[1].length);

        for (int[] array:
             test) {
            System.out.println(Arrays.toString(array));
        }


        System.out.println(1234 / 100 % 10);//2
        System.out.println(34 / 100 % 10);//0
    }
}
