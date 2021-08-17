package com.lujun61.algorithm.radix;

import java.util.Arrays;

/**
 * @description 本类是基于RadixSort类的改进
 * @author Jun Lu
 * @date 2021-08-17 16:05:09
 */
public class UpdateRadixSort {
    public static void main(String[] args) {
        //定义需要排序的数组
        int[] arrays = new int[]{53, 546662, 3, 63, 14, 214, 154, 748, 616, 5};

        radixSort(arrays);
    }

    /**
     * @param arrays 传入的待排序的数组
     * @return void
     * @description 基数排序核心方法
     * @author Jun Lu
     * @date 2021-08-17 15:38:12
     */
    private static void radixSort(int[] arrays) {
        //1、获取传入的待排序的数组中最大值的长度（基数位数）
        int max = 0;
        for (int array : arrays) {
            if (array > max) {
                max = array;
            }
        }
        int maxNumLength = String.valueOf(max).length();//获取最大值的长度

        //2、定义十个桶（二维数组）；原因：十个桶下标(编号)范围是0~9，即代表了构成所有数字的基数。每个桶的容量即为：待排序数据的总量
        int[][] buckets = new int[10][arrays.length];

        //3、定义一个辅助数组，方便从桶中取值。容量也要和桶一样：原因：同2
        int[] assistArray = new int[10];

        //基数有几位，就循环多少次
        for (int i = 0, j = 1; i < maxNumLength; i++, j *= 10) {
            for (int val:
                    arrays) {
                int unitRadix = val / j % 10;//取出各个数据个位的值

                buckets[unitRadix][assistArray[unitRadix]++] = val;
            }
            depositArray(assistArray, arrays, buckets);
        }

        //遍历桶中数据
        System.out.println(Arrays.toString(arrays));
    }

    /**
     * @param assistArray 辅助数组：用来存放十个桶中各个桶存放的数据的个数
     * @param arrays 存放待排序数据的数组
     * @param buckets 以各个待排序数据的基数作为下标，存放数据的“桶”
     * @return void
     * @description 将排序完毕的数据重新存入原数组，以便下一次排序/完成排序
     * @author Jun Lu
     * @date 2021-08-17 11:39:06
     */
    public static void depositArray(int[] assistArray, int[] arrays, int[][] buckets) {
        int index = 0;
        for (int i = 0; i < assistArray.length; i++) {
            if (assistArray[i] != 0) {
                for (int j = 0; j < assistArray[i]; j++) {
                    arrays[index++] = buckets[i][j];
                }
            }
            assistArray[i] = 0;//辅助数组对应的那几个值已经取出，则需要归0
        }
    }
}
