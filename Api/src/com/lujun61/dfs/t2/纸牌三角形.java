package com.lujun61.dfs.t2;

public class 纸牌三角形 {
    static int numSize = 9;
    static int len = numSize + 1;
    static int[] nums = new int[len];
    static boolean[] used = new boolean[len];
    static int count = 0;
    public static void main(String[] args) {
        dfs(1);
        System.out.println(count / 6);
    }

    public static void dfs(int depth) {
        if (depth == len) check();

        for (int i = 1; i <= numSize; i++) {
            if (used[i]) continue;
            nums[depth] = i;
            used[i] = true;
            dfs(depth + 1);
            used[i] = false;
            nums[depth] = 0;
        }
    }

    public static void check() {
        int left = nums[1] + nums[2] + nums[3] + nums[4];
        int right = nums[1] + nums[5] + nums[6] + nums[7];
        int down = nums[4] + nums[8] + nums[9] + nums[7];

        if (left == right && left == down) count++;
    }
}
