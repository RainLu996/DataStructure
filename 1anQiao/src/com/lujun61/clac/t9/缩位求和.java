package com.lujun61.clac.t9;

import java.util.Scanner;

public class 缩位求和 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();

        int len = str.length();
        int ans = 0;
        int val = Integer.parseInt(str);
        while (len != 1) {
            ans = 0;
            for (int i = 0; i < len; i++) {
                ans += val % 10;
                val /= 10;
            }
            len = String.valueOf(ans).length();
            val = ans;
        }
        System.out.println(ans);
    }
}
