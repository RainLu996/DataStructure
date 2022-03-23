package com.lujun61.search.insert;

import java.util.Scanner;

public class InsertSearch {
    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(insertSearch(arrays, 10));
    }

    public static int insertSearch(int[] arrays, int target) {
        int left = 0;
        int right = arrays.length - 1;
        int mid = 0;

        if (target < arrays[left] || target > arrays[right]) {
            return -1;
        }

        while (left <= right) {
            mid = left + (right - left) * (target - arrays[left]) / (arrays[right] - arrays[left]);
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
        Scanner s = new Scanner(System.in);
        
        return -1;
    }
}
