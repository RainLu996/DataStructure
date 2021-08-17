package com.lujun61.algorithm.bubble;

import java.util.Arrays;

/**
 * @description 冒泡排序
 * @author Jun Lu
 * @date 2021-08-17 16:09:26
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arrays = new int[]{53, 542, 3, 63, 14, 214, 154, 748, 616, 5};

        bubbleSort(arrays);

        System.out.println(Arrays.toString(arrays));
    }

    /**
     * @param arrays 传入的待排序的数组
     * @return void
     * @description 使用冒泡排序；其中涉及到两数之间直接交换值
     * @author Jun Lu
     * @date 2021-08-17 16:07:39
     */
    public static void bubbleSort(int[] arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {//如果有十个数据，则至少比较（10-1）趟
            for (int j = 0; j < arrays.length - 1 - i; j++) {
                if (arrays[j] < arrays[j + 1]) {
                    arrays[j]     = arrays[j] ^ arrays[j + 1];
                    arrays[j + 1] = arrays[j] ^ arrays[j + 1];
                    arrays[j]     = arrays[j] ^ arrays[j + 1];
                }
            }
        }
    }
}
