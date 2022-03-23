package com.lujun61.algorithm.merge;

import java.util.Arrays;

/**
 * @description 归并排序
 * @author Jun Lu
 * @date 2021-10-05 16:36:42
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arrays = {1, 4, 7, 3, 8, 2, 9, 10};

        //定义一个临时数组，便于将最终排序好的数据转交给调用者
        int[] temp = new int[arrays.length];

        divide(arrays, 0, arrays.length - 1, temp);

        System.out.println(Arrays.toString(arrays));
    }

    /**
     * @param arrays 原数组
     * @param left 左半边的起点
     * @param right 右半边的起点
     * @param temp 临时数组
     * @description 二分数据
     * @author Jun Lu
     * @date 2021-10-05 16:36:59
     */
    public static void divide(int[] arrays, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;//动态变化

            //向左分解
            divide(arrays, left, mid, temp);

            //向右分解
            divide(arrays, mid + 1, right, temp);

            //分解完成，合并数据
            merge(arrays, left, right, mid, temp);
        }
    }

    /**
     * @param arrays 原数组
     * @param left 左半边的起点
     * @param right 右半边的起点
     * @param mid 中点
     * @param temp 临时数据
     * @description 合并数据
     * @author Jun Lu
     * @date 2021-10-05 16:38:03
     */
    public static void merge(int[] arrays, int left, int right, int mid, int[] temp) {
        int tmpPoint = 0;
        int lStart = left;
        int rStart = mid + 1;

        //降序
        while (lStart <= mid && rStart <= right) {  //小总结：不变的量，不用设置一个临时变量存放它:例如：right与mid
            if (arrays[lStart] <= arrays[rStart]) {
                temp[tmpPoint] = arrays[lStart];
                tmpPoint++;
                lStart++;
            } else {
                temp[tmpPoint] = arrays[rStart];
                tmpPoint++;
                rStart++;
            }
        }


        //将两边多余的数据直接插入到temp数组中（适用于无法平分的情况）
        while (lStart <= mid) {
            temp[tmpPoint] = arrays[lStart];
            tmpPoint++;
            lStart++;
        }
        while (rStart <= right) {
            temp[tmpPoint] = arrays[rStart];
            tmpPoint++;
            rStart++;
        }


        //将临时数组中已经排序好的值重新赋值给原始数组
        tmpPoint = 0;
        while (left <= right) {
            arrays[left] = temp[tmpPoint];
            tmpPoint++;
            left++;
        }
    }
}
