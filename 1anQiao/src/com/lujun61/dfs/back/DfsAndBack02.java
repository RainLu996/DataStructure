package com.lujun61.dfs.back;

import java.util.*;

/**
 * @author Jun Lu
 * @description dfs回溯：
 * 1、进行选择
 * 2、递归
 * 3、撤回选择
 * @date 2022-03-18 18:10:59
 */

/**
 * 考虑去重的dfs
 */

/**
 * 力扣题单
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class DfsAndBack02 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[len];
        if (len == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(nums, len, 0, path, res, used);
        return res;
    }

    public void dfs(int[] nums, int len, int depth, Deque<Integer> path, List<List<Integer>> res, boolean[] used) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            /*
                (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])：去重原理解释：
                元素被使用过；当前元素等于列表中前一个元素时，如果前一个元素被使用过，才能将当前元素入列表
             （确保重复元素之间的排列只有一种排列方式）。
            */
            if (used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])) continue;
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, res, used);
            used[i] = false;
            path.removeLast();
        }
    }
}
