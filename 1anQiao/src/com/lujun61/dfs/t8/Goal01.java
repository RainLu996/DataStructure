package com.lujun61.dfs.t8;

public class Goal01 {
    static int[] arr =
            {9090400, 8499400, 5926800, 8547000, 4958200, 4422600, 5751200,
                    4175600, 6309600, 5865200, 6604400, 4635000,
                    10663400, 8087200, 4554000};

    static int min = Integer.MAX_VALUE;
    static int sum = 0;
    static boolean[] visited = new boolean[arr.length];

    public static void main(String[] args) {
        for (int x = 0; x < arr.length; x++) {
            sum += arr[x];
        }
        dfs(0);
        System.out.println(min);
    }

    public static void dfs(int avg) {
        if (avg >= sum / 2) {
            min = Math.min(min, Math.abs(sum - avg * 2));
            return;
        }
        for (int x = 0; x < arr.length; x++) {
            if (!visited[x]) {
                visited[x] = true;
                dfs(avg + arr[x]);
                visited[x] = false;
            }
        }
    }
}
