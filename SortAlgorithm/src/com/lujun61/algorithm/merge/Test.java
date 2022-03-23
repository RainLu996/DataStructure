package com.lujun61.algorithm.merge;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arrays = {8,4,7,2,3,6,1,5};

        /**
         * 定义一个临时数组
         */
        int[] temp = new int[arrays.length];
        mSort(arrays,0,arrays.length-1,temp);
        System.out.println(Arrays.toString(arrays));
    }

    public static void mSort(int[] array,int left,int right,int[] temp){
        if (left<right){
            int mid = (left+right)/2;

            /**
             * 向左进行分解
             */
            mSort(array,left,mid,temp);

            /**
             * 向右分解
             */
            mSort(array,mid+1,right,temp);

            /**
             * 合并
             */
            sort(array,left,right,mid,temp);
        }
    }

    public static void sort(int[] arrays,int left,int right,int mid,int[] temp){
        /**
         * 初始化i，指向左边序列的初始索引值
         */
        int i = left;
        /**
         * 初始化j，指向右边序列初始值
         */
        int j = mid+1;

        /**
         * 初始化 t，指向数组的当前索引
         */
        int t = 0;

        /**
         * 先把左右两边的数据按照有序序列方式填充到temp数组中
         * 直至左右两边的有序序列，有一边处理完毕为止
         */
        while (i<=mid && j<=right){

            /**
             * 如果左边的有序序列的当前元素小于等于右边有序序列的当前元素，即让左边的当前元素填充到temp数组中
             然后 t++,i++
             */
            if (arrays[i]<=arrays[j]){
                temp[t] = arrays[i];
                t+=1;
                i+=1;
            }else {
                temp[t] = arrays[j];
                t+=1;
                j+=1;
            }
        }
        /**
         * 把剩余数据的一边的数据一次全部填充到temp；
         */
        while (i<=mid){
            temp[t] = arrays[i];
            t+=1;
            i+=1;
        }

        while (j<=right){
            temp[t] = arrays[j];
            t+=1;
            j+=1;
        }

        /**
         * 将temp数组中的元素拷贝至arrays数组中。这里不是每次拷贝所有的元素
         */
        t=0;
        int tempIndex = left;
        while (tempIndex<=right){
            arrays[tempIndex] = temp[t];
            t+=1;
            tempIndex +=1;
        }
    }
}