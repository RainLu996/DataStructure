package com.lujun61.dfs.template;

public class 回溯模板2 {
    public static void main(String[] args) {
        char[] eles = {};
        dfs(0, eles);

    }

    private static void dfs(int depth, char[] eles) {
        if (depth == eles.length) {
            check();
        }

        /**
         * 回溯核心代码
         */
        for (int i = depth; i < eles.length; i++) {
            char temp = eles[depth];
            eles[depth] = eles[i];
            eles[i] = temp;

            dfs(depth + 1, eles);

            temp = eles[depth];
            eles[depth] = eles[i];
            eles[i] = temp;
        }
    }

    private static boolean check() {
        return false;
    }
}
