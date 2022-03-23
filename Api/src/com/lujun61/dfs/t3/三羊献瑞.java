package com.lujun61.dfs.t3;


/**
 * ABCD + EFGB = EFCBH
 */
public class 三羊献瑞 {
    static int len = 10;
    static boolean[] used = new boolean[len];
    static int[] nums = new int[len];

    public static void main(String[] args) {
        dfs(0);
    }

    public static void dfs(int depth) {
        //递归结束条件：代表一种 全排列结果 的完整生成
        if (depth == len) check();

        for (int i = 0; i <= 9; i++) {
            if (used[i]) continue;     //全排列加入元素
            used[i] = true;
            nums[depth] = i;     //递归
            dfs(depth + 1);
            used[i] = false;
            nums[depth] = 0;     //回溯
        }
    }

    /**
     * ABCD + EFGB = EFCBH
     *
     * 注意点：参与全排列的元素有0~9，共计 十个 元素
     */
    public static void check() {
        int a = nums[0] * 1000 + nums[1] * 100 + nums[2] * 10 + nums[3];
        int b = nums[4] * 1000 + nums[5] * 100 + nums[6] * 10 + nums[1];
        int c = nums[4] * 10000 + nums[5] * 1000 + nums[2] * 100 + nums[1] * 10 + nums[7];

        if (a + b == c && a + b > 10000) {
            System.out.println(b);
        }
    }
}
