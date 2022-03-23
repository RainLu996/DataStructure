package com.lujun61.search.linear;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arrays = {1, 4, 4, 7, 3, 8, 2, 9, 10};

        System.out.println(linearSearch(arrays, 4));
    }

    /**
     * @param arrays 被查找的数组
     * @param target 查找的目标元素
     * @return int 查找成功，返回元素对应下标；查找失败，返回-1
     * @description 线性查找算法（效率低下）：查找元素第一次出现的数组下标
     * @author Jun Lu
     * @date 2021-10-05 17:03:10
     */
    public static int linearSearch(int[] arrays, int target) {
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
