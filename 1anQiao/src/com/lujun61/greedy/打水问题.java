package com.lujun61.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 打水问题 {  /* 先让打水时间短的打水，将会达到最短的等待时间 */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        int[] peo = new int[n];//存储每个人打水所需时间
        int[] wat = new int[m];//m个水龙头
        for (int i = 0; i < n; i++) {
            peo[i] = s.nextInt();
        }

        Arrays.sort(peo);
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += wat[i % m];
            wat[i % m] += peo[i];
        }

        System.out.println(count);
    }
}
