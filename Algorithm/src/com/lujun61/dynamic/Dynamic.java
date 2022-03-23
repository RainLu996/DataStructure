package com.lujun61.dynamic;

/*
    给定一个矩阵m，从左上角开始每次只能向右走或者向下走，最后达到右下角的位置，
    路径中所有数字累加起来就是路径和，返回所有路径的最小路径和，如果给定的m如下，
    那么路径1,3,1,0,6,1,0就是最小路径和，返回12
*/

import java.util.Arrays;

public class Dynamic {
    public static void main(String[] args) {
        int[][] arry = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        System.out.println(myDynamic(arry));
    }

    /**
     * @param arry 案例数组
     * @return int 案例中的【结果值】
     * @description 动态规划案例实现
     * @author Jun Lu
     * @date 2022-03-13 21:44:16
     */
    public static int myDynamic(int[][] arry) {
        if (arry.length == 0 || arry == null) {
            return -1;
        }

        //dp数组要和arry数组的大小一致
        int[][] dp = new int[arry.length][arry[0].length];
        /* 根据所给问题，给dp数组设置起点值 */
        dp[0][0] = arry[0][0];

        /* 给第一行dp数组赋值 */
        for (int i = 1; i < arry[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + arry[0][i];
        }

        for (int i = 1; i < arry.length; i++) {
            for (int j = 0; j < arry[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + arry[i][j];
                } else if (dp[i - 1][j] < dp[i][j - 1]) {  //如果当前位置的 子结果数组中的【上边的值】小于【左边的值】
                    dp[i][j] = dp[i - 1][j] + arry[i][j];
                } else dp[i][j] = dp[i][j - 1] + arry[i][j];  //如果当前位置的 子结果数组中的【左边的值】小于【上边的值】
            }
        }

        printArray(dp);

        //返回终点值
        return dp[dp.length - 1][dp[0].length - 1];
    }

    /**
     * 打印二维数组
     */
    public static void printArray(int[][] arrays) {
        for (int[] array :
                arrays) {
            System.out.println(Arrays.toString(array));
        }
    }
}
