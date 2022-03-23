package com.lujun61.binary;


public class BinarySearch {
    public static void main(String[] args) {
        int[] arrarys = {1, 2, 43 ,45, 55, 66, 77};

        int val = binarySearch(arrarys, 6);
        System.out.println("目标值索引：" + val);
    }


    /**
     * @param arrarys 目标数组
     * @param target 查询的目标值
     * @return int 有目标值，返回对应索引；没有返回-1
     * @description 二分查找算法
     * @author Jun Lu
     * @date 2022-03-13 11:21:32
     */
    public static int binarySearch(int[] arrarys, int target) {
        int min = 0;
        int max = arrarys.length;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (arrarys[mid] == target) {
                return mid;
            } else if (arrarys[mid] < target) {
                min = mid + 1;
            } else max = mid - 1;
        }

        return -1;
    }
}
