package com.lujun61.algorithm;

import java.util.Arrays;

/**
 * @description 基数排序
 * @author Jun Lu
 * @date 2021-08-16 21:11:35
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arrays = new int[]{53, 542, 3, 63, 14, 214, 154, 748, 616, 5};
        
        radixSort(arrays);
    }


    private static void radixSort(int[] arrays) {
        //1、获取传入的待排序的数组中最大值的长度（位数）
        int max = 0;
        for (int array : arrays) {
            if (array > max) {
                max = array;
            }
        }
        //int maxNumLength = String.valueOf(max).length();//获取最大值的长度

        //2、定义十个桶（二维数组）；原因：十个桶下标(编号)范围是0~9，即代表了构成所有数字的基数。每个桶的容量即为：待排序数据的总量
        int[][] buckets = new int[10][arrays.length];

        //3、定义一个辅助数组，方便从桶中取值。容量也要和桶一样：原因相同
        int[] assistArray = new int[10];

        //4、往桶中存放值
        /*通过个位的基数排序*/
        for (int array:
             arrays) {
            int unitRadix = array%10;//取出各个数据个位的值

            //assistArray[decadeRadix]的初始默认值是：0。所以存放一个值之后，需要递增：1
            buckets[unitRadix][assistArray[unitRadix]++] = array;
        }
        depositArray(assistArray, arrays, buckets);

        /*通过十位的基数排序*/
        for (int array :
             arrays) {
            int decadeRadix = array / 10 % 10;

            buckets[decadeRadix][assistArray[decadeRadix]++] = array;
        }
        depositArray(assistArray, arrays, buckets);

        /*通过百位的基数排序*/
        for (int array :
             arrays) {
            int hundredRadix = array / 100 % 10;

            buckets[hundredRadix][assistArray[hundredRadix]++] = array;
        }
        depositArray(assistArray, arrays, buckets);

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
