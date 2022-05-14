package com.lujun61.arrays.t1;

import java.util.Arrays;
import java.util.Scanner;


/**
 * https://blog.csdn.net/weixin_41356040/article/details/108011937
 */
public class 双向排序 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt();
        Integer[] arr = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int p = s.nextInt();
            int split = s.nextInt();
            if (p == 0) {
                /**
                 * 要排序的范围为： fromIndex （包括）~ index toIndex （不包括）。
                 * （即：如果fromIndex == toIndex ，则要排序的范围为空。）
                 */
                Arrays.sort(arr, 1, split + 1, (a, b) -> Integer.compare(b, a));   //降序  （b > a）
            } else {
                Arrays.sort(arr, split, n + 1);   //升序
            }
        }

        for (int i = 1; i <= n; i++) {
            if (i > 1) {
                System.out.print(" ");
            }
            System.out.print(arr[i]);
        }

        s.close();
    }
}
