package com.lujun61.dfs.t5;

import java.util.Scanner;

public class Goal {
    static int ans;  //全局变量
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        f(arr, 0);  //全排列函数
        System.out.println(ans);
    }

    //确认某一个排列的第k位
    private static void f(int[] arr, int k) {
        if (k == 9) {  //全部确认
            check(arr);
            return;
        }
        //选定第k位，
        for (int i = k; i < arr.length; i++) {
            //将第i位和第k位交换
            int t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;
            f(arr, k + 1); // 移交下一层 确认第k+1位
            //回溯(换回来) 不影响以后的取值
            //每一次计算, 都用初始值
            t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;
        }
    }
    //枚举加号和除号的位置
    private static void check(int[] arr) {
        //+前的字符数最多是7
        for (int i = 1; i <= 9; i++) {
            int num1 = toInt(arr, 0, i);  //+前面的一段整数
            if (num1 >= N) continue;  //如果此时+号前的数值已经超过了N，没必要验算了
            //  /前面的字符数
            for (int j = 1; j <= 8 - i; j++) {
                int num2 = toInt(arr, i, j);
                int num3 = toInt(arr, i + j, 9 - i - j);
                if (num2 % num3 == 0 && num1 + num2 / num3 == N) {
                    ans++;
                }
            }
        }
    }

    //pos: 开始计算的位置;   len:计算的长度(计算len次)   计算区间: [pos, pos + len -1]
    private static int toInt(int[] arr, int pos, int len) {
        int t = 1;
        int ans = 0;
        for (int i = pos + len - 1; i >= pos; i--) {
            ans += arr[i] * t;
            t *= 10;
        }
        return ans;
    }
}
