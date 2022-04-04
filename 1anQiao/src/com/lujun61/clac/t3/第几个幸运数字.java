package com.lujun61.clac.t3;

public class 第几个幸运数字 {
    public static void main(String[] args) {
        long n = 59084709587505L;

        int ans = 0;
        for (int i = 0; Math.pow(7, i) < n; i++) {
            for (int j = 0; Math.pow(5, j) < n; j++) {
                for (int k = 0; Math.pow(3, k) < n; k++) {
                    if (Math.pow(7, i) * Math.pow(5, j) * Math.pow(3, k) < n) {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
