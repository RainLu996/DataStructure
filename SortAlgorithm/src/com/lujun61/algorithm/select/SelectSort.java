package com.lujun61.algorithm.select;

import java.util.Arrays;

/**
 * @description 选择排序    要区分于：插入排序
 * @author Jun Lu
 * @date 2021-10-04 13:54:55
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arrays = {1, 4, 4, 7, 3, 8, 2, 9, 10};

        /*
           将i部分看做已经排好序的一部分；将j部分看做无序数据的那一部分；
           i部分逐渐增多，j部分逐渐减少
        */
        //第一层循环控制着需要找多少轮
        for (int i = 0; i < arrays.length; i++) {
            //第二层循环控制着在每一轮中寻找最大、最小值
            for (int j = arrays.length - 1; j > i; j--) {
                if (arrays[i] < arrays[j]) {
                    arrays[i] = arrays[i] ^ arrays[j];
                    arrays[j] = arrays[i] ^ arrays[j];
                    arrays[i] = arrays[i] ^ arrays[j];
                }
            }
        }
        System.out.println(Arrays.toString(arrays));
    }
}
