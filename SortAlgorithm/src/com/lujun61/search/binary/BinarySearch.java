package com.lujun61.search.binary;

/**
 * @description 二分查找算法
 *                  使用时的前提条件：
 *                      1、数据的存储结构必须是：顺序存储结构
 *                      2、数据的排序方式必须是：有序的
 * @author Jun Lu
 * @date 2021-10-05 17:15:55
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(binarySearch(arrays, 3));
    }

    /**
     * @param arrays 被查找的数组
     * @param target 查找的目标元素
     * @return int 查找成功，返回元素对应下标；查找失败，返回-1
     * @description 二分查找算法（效率较高）：查找元素第一次出现的数组下标
     * @author Jun Lu
     * @date 2021-10-05 17:21:50
     */
    public static int binarySearch(int[] arrays, int target) {
        int left = 0;
        int right = arrays.length - 1;
        int mid = 0;

        if (target < arrays[left] || target > arrays[right]) {
            return -1;
        }

        while (left <= right) {
            mid = (left + right)/2;
            if (arrays[mid] == target) {
                return mid;
            }
            if (arrays[mid] < target) {
                left = mid + 1;
            }
            if (arrays[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
