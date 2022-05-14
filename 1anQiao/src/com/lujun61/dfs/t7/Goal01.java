package com.lujun61.dfs.t7;

public class Goal01 {
    static int count = 0;

    public static void main(String[] args) {
        boolean[][] bool = new boolean[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                dfs(bool, i, j, 1);    //把每个‘点’当做起点进行dfs
            }
        }
        System.out.println(count);
    }

    private static void dfs(boolean[][] bool, int x, int y, int depth) {
        /* 边界（结束递归）条件 */
        if (x == 4 || y == 4 || x == -1 || y == -1 || bool[x][y]) {
            return;
        }

        if (depth == 16) {
            count++;
            return;
        }

        bool[x][y] = true;
        dfs(bool, x + 1, y, depth + 1);
        dfs(bool, x - 1, y, depth + 1);
        dfs(bool, x, y + 1, depth + 1);
        dfs(bool, x, y - 1, depth + 1);
        bool[x][y] = false;
    }
}
