package com.lujun61.dynamic.t2;

import java.util.Scanner;

public class 取球游戏 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] mark = new int[10008];
        for (int i = 1; i < 10000; i++) {
            //赋值条件：对A而言为赢
            if (mark[i] == 0) {   //A先取，但A取完就没有剩余的球，则A必输；若有剩余的球，则按照规则来赋值
                mark[i + 1] = 1;
                mark[i + 3] = 1;
                mark[i + 7] = 1;
                mark[i + 8] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(mark[s.nextInt()]);
        }
    }
}
