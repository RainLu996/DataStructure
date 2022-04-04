package com.lujun61.law.t1;

import java.util.Scanner;

public class Practise {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int c = s.nextInt();

        int[][] pre = new int[r + 1][c + 1];
        int[][] cur = new int[r + 2][c + 2];

        int pipe = s.nextInt();
        //初始化数组
        for (int i = 0; i < pipe; i++) {
            int rr = s.nextInt();
            int cc = s.nextInt();
            pre[rr][cc] = 1;
            cur[rr][cc] = 1;
        }

        int count = 0;
        int t = s.nextInt();
        for (int i = 1; i <= t; i++) {
            for (int j = 1; j <= r; j++) {
                for (int k = 1; k <= c; k++) {
                    if (pre[j][k] == 1) {
                        cur[j - 1][k] = 1;//上
                        cur[j + 1][k] = 1;//下
                        cur[j][k - 1] = 1;//左
                        cur[j][k + 1] = 1;//右
                    }
                }
            }

            /* 更新pre */
            for (int j = 1; j <= r; j++) {
                for (int k = 1; k <= c; k++) {
                    if (cur[j][k] == 1) {
                        pre[j][k] = 1;
                        if (i == t) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
