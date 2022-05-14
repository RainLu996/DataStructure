package com.lujun61.dfs.t7;

public class Goal02 {
    public static int count = 0;
    public static boolean visited[][];
    public static void main(String[] args) {
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                visited = new boolean[4][4];
                visited[i][j] = true;
                dfs(i, j, 15);
                visited[i][j] = false;
            }
        }
        /*visited = new boolean[4][4];
        visited[0][0] = true;
        dfs(0, 0, 15);*/
        System.out.println(count);
    }
    public static void dfs(int x, int y, int l) {
        if(l == 0) {
            count++;
            return;
        }
        //System.out.println(x + " " + y + " " + l);
        //向上
        if(x-1 >= 0 && !visited[x-1][y]) {
            visited[x-1][y] = true;
            dfs(x-1, y, l-1);
            visited[x-1][y] = false;
        }
        //向下
        if(x+1 <= 3 && !visited[x+1][y]) {
            visited[x+1][y] = true;
            dfs(x+1, y, l-1);
            visited[x+1][y] = false;
        }
        //向左
        if(y-1 >= 0 && !visited[x][y-1]) {
            visited[x][y-1] = true;
            dfs(x, y-1, l-1);
            visited[x][y-1] = false;
        }
        //向右
        if(y+1 <= 3 && !visited[x][y+1]) {
            visited[x][y+1] = true;
            dfs(x, y+1, l-1);
            visited[x][y+1] = false;
        }

        return;
    }
}
