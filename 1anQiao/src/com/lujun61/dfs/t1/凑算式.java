package com.lujun61.dfs.t1;

public class 凑算式 {
    public static final int numSize = 9;  //参与全排列的元素个数
    public static int len = 10;  //初始化容器大小
    static int count = 0;
    static boolean[] used = new boolean[len];
    static int[] nums = new int[len];

    public static void main(String[] args) {
        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int depth) {
        //递归结束条件：代表一种 全排列结果 的完整生成
        if (depth == len) check();

        for (int i = 1; i <= numSize; i++) {
            if (used[i]) continue;
            used[i] = true;
            nums[depth] = i;     //递归
            dfs(depth + 1);
            used[i] = false;
            nums[depth] = 0;     //回溯
        }
    }


    /* 原式等于 B*GHI + C*DEF = (10 - A)*C*GHI */
    public static void check() {
        int B_GHI = nums[2] * (nums[7] * 100 + nums[8] * 10 + nums[9]);
        int C_DEF = nums[3] * (nums[4] * 100 + nums[5] * 10 + nums[6]);
        int C_GHI = nums[3] * (nums[7] * 100 + nums[8] * 10 + nums[9]);

        if ((B_GHI + C_DEF) == (10 - nums[1]) * C_GHI) count++;
    }
}
