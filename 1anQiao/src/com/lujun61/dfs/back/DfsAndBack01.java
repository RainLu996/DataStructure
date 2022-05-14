package com.lujun61.dfs.back;

import java.util.*;

/**
 * @author Jun Lu
 * @description dfs回溯：
 *                  1、进行选择
 *                  2、递归
 *                  3、撤回选择
 * @date 2022-03-18 18:10:59
 */

/**
 * 未考虑去重的dfs
 */

/**
 * 力扣题单
 * https://leetcode-cn.com/problems/permutations/
 */
public class DfsAndBack01 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[len];
        if (len == 0) {
            return res;
        }
        dfs(nums, len, 0, path, res, used);
        return res;
    }

    public void dfs(int[] nums, int len, int depth, Deque<Integer> path, List<List<Integer>> res, boolean[] used) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) continue;    //如果当前元素被使用过，则进入下一次循环，使用下一个元素
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, res, used);
            used[i] = false;
            path.removeLast();
        }
    }
}
