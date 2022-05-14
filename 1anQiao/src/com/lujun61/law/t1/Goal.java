package com.lujun61.law.t1;

import java.util.Scanner;

/**
 * 暴力模拟
 */
public class Goal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//花园行数
        int m = sc.nextInt();//花园列数
        int t = sc.nextInt();//出水口数
        int r, c;
        int[][] cur = new int[n + 2][m + 2];//为何数组容量这样初始化，见img_2.png
        int[][] pre = new int[n + 1][m + 1];//为何数组容量这样初始化，见img_2.png
        for (int i = 0; i < t; i++) {  //t个出水口
            r = sc.nextInt();   //出水口行
            c = sc.nextInt();   //出水口列
            pre[r][c] = 1;  //扩展之前的湿地
            cur[r][c] = 1;  //扩展之后的湿地
        }

        int count = 0;
        int k = sc.nextInt();//时间
        for (int i = 1; i <= k; i++) {//k分钟会扩展k次
            //遍历“花园”找水管（湿地）
            for (int j = 1; j <= n; j++) {
                for (int s = 1; s <= m; s++) {
                    if (pre[j][s] == 1) {//当前为湿地
                        cur[j - 1][s] = 1;//经过该时间后，此地为湿地 【上】
                        cur[j + 1][s] = 1;//经过该时间后，此地为湿地 【下】
                        cur[j][s - 1] = 1;//经过该时间后，此地为湿地 【左】
                        cur[j][s + 1] = 1;//经过该时间后，此地为湿地 【右】
                    }
                }
            }

            /* 更新pre数组：把cur数组中的值赋值给pre数组 */
            for (int j = 1; j <= n; j++) {
                for (int l = 1; l <= m; l++) {
                    if (cur[j][l] == 1) {
                        pre[j][l] = cur[j][l];
                        if (i == k) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
