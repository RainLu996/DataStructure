package com.lujun61.original.t2;

import java.util.HashMap;
import java.util.Map;

public class 卡片 {
    public static void main(String[] args) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 1; i < 100000; i++) {
            if (m.containsValue(2021)) {
                System.out.println(i - 1);
                break;
            }
            int len = String.valueOf(i).length();
            int temp = i;
            for (int j = 0; j < len; j++) {
                int mod = temp % 10;
                temp /= 10;
                if (!m.containsKey(mod)) {
                    m.put(mod, 1);
                } else {
                    m.put(mod, m.get(mod) + 1);
                }
            }
        }
    }
}
