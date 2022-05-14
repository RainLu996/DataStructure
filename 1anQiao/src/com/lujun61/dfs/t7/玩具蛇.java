package com.lujun61.dfs.t7;

public class 玩具蛇 {
    static boolean[][] used = new boolean[4][4];
    static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                dfs(i, j, 1);   //从某个顶点进入是说：当前深度为 1 ， 而不是 0！！！
            }
        }

        System.out.println(count);
    }

    private static void dfs(int i, int j, int depth) {
        if (i == 4 || j == 4 || i == -1 || j == -1 || used[i][j]) {
            return;
        }

        if (depth == 16) {
            count++;
            return;
        }

        used[i][j] = true;

        dfs(i + 1, j, depth + 1);
        dfs(i - 1, j, depth + 1);
        dfs(i, j + 1, depth + 1);
        dfs(i, j - 1, depth + 1);

        used[i][j] = false;
    }
}
