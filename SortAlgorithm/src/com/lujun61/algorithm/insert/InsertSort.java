package com.lujun61.algorithm.insert;

import java.util.Arrays;

/**
 * @description 插入排序，适合于小型的数据排序
 * @author Jun Lu
 * @date 2021-10-04 13:11:30
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arrays = {1, 4, 4, 7, 3, 8, 2, 9, 10};

        System.out.println(Arrays.toString(insertSort(arrays)));
    }

    public static int[] insertSort(int[] arrays) {
        //第一层循环控制拿哪个元素出来进行比较
        //第一个元素不需要比较所以“i=1”
        for (int i = 1; i < arrays.length; i++) {
            //第二层循环控制将元素与前一个元素进行比较
            for (int j = i; j >= 1; j--) {
                if (arrays[j] < arrays[j - 1]) {
                    arrays[j] = arrays[j] ^ arrays[j - 1];
                    arrays[j - 1] = arrays[j] ^ arrays[j - 1];
                    arrays[j] = arrays[j] ^ arrays[j - 1];
                }else  break;
            }
        }
        return arrays;
    }
}
