package com.lujun61.dfs.t8;

public class Goal02 {
    static int sum;
    static int cnt = Integer.MAX_VALUE;
    static int[] value =
            {9090400, 8499400, 5926800, 8547000, 4958200, 4422600, 5751200,
                    4175600, 6309600, 5865200, 6604400, 4635000,
                    10663400, 8087200, 4554000};

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) sum += value[i];

        dfs(0, 0);

        System.out.print(cnt);
    }

    static void dfs(int d, int v) {
        if (d == 15) {
            cnt = Math.min(cnt, Math.abs(sum - v - v));
            return;
        }


        dfs(d + 1, v + value[d]);
        dfs(d + 1, v);
    }
}
