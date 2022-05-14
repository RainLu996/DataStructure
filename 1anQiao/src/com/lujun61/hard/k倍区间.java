package com.lujun61.hard;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class k倍区间 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        //注意要用long数组,数据量较大
        long[] arr = new long[N + 1];
        //Map前面也得用Long,因为有long参与的运算返回值也是long
        Map<Long, Integer> map = new HashMap<>();
        //获得前缀和数组
        for (int i = 0; i < N; ++i) {
            arr[i + 1] = arr[i] + sc.nextLong();
        }
        long ans = 0;
        //千万不能忘记把这个忘记放入
        map.put(0L, 1);
        for (int i = 1; i <= N; ++i) {
            ans += map.getOrDefault(arr[i] % k, 0);
            map.put(arr[i] % k, map.getOrDefault(arr[i] % k, 0) + 1);
        }
        System.out.println(ans);
    }
}
