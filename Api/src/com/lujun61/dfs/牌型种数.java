package com.lujun61.dfs;


import java.util.ArrayDeque;
import java.util.Deque;

/*
    小明被劫持到X赌城，被迫与其他3人玩牌。

    一副扑克牌（去掉大小王，共52张），均匀发给4个人，每个人13张

    这时，小明脑子里突然想到一个问题：

    如果不考虑花色，只考虑点数，也不考虑自己得到的牌的先后顺序，自己手里能拿到的初始牌型组合一共有多少种呢？
 */
public class 牌型种数 {
    static int count = 0;
    public static void main(String[] args) {
        //创建一幅扑克牌：只包含单个花色
        int[] nums = new int[13];

        int index = 0;  //扑克牌位置索引
        for (int i = 1; i <= 13; i++) {
            nums[index++] = i;
        }

        int len = nums.length;

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, len, nums, used, path);

        System.out.println(count);
    }

    public static void dfs(int depth, int len, int[] nums, boolean[] used, Deque<Integer> path) {
        if (path.size() == len) {
            count++;
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) continue;

            path.addLast(nums[i]);
            used[i] = true;
            dfs(depth + 1, len, nums, used, path);
            used[i] = false;
            path.removeLast();
        }
    }















}
