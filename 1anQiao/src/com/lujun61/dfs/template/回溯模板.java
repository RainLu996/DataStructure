package com.lujun61.dfs.template;


/**
 * @description 先将全排列结果得出，再代入到判断条件中求出所要求的结果
 * @author Jun Lu
 * @date 2022-03-21 19:13:55
 */
public class 回溯模板 {
    static int numSize = 0;  //参与全排列的元素个数
    static int len = numSize + 1;  //初始化容器大小；加1更便于理解含义
    static int count = 0;
    static boolean[] used = new boolean[len];
    static int[] nums = new int[len];

    public static void main(String[] args) {
        /**
         * 此全排列模板只针对于1~9，共计九个元素使用。
         * 若是0~9使用此全排列模板，就参考三羊献瑞模板使用！！！
         */

        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int depth) {
        //递归结束条件：代表一种 全排列结果 的完整生成
        if (depth == numSize + 1) check();

        for (int i = 1; i <= numSize; i++) {
            if (used[i]) continue;     //全排列加入元素
            used[i] = true;
            nums[depth] = i;     //递归
            dfs(depth + 1);
            used[i] = false;
            nums[depth] = 0;     //回溯
        }
    }

    public static void check() {
        /**
         * 逻辑判断代码
         */
    }
}
