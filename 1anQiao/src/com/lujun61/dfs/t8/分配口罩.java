package com.lujun61.dfs.t8;

public class 分配口罩 {
    static int[] arr =
            {9090400, 8499400, 5926800, 8547000, 4958200, 4422600, 5751200,
                    4175600, 6309600, 5865200, 6604400, 4635000,
                    10663400, 8087200, 4554000};

    static int min = Integer.MAX_VALUE;
    static int sum = 0;
    static boolean[] visited = new boolean[arr.length];

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        dfs(0);

        System.out.println(min);
    }

    private static void dfs(int avg) {
        if (avg >= sum / 2) {
            min = Math.min(min, Math.abs(sum - avg * 2));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(avg + arr[i]);
            visited[i] = false;

        }
    }
}
