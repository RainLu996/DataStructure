package com.lujun61.think.t1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
    小明正看着 203879 这个数字发呆。

    原来，203879∗203879=41566646641。

    这有什么神奇呢？仔细观察，203879 是个 6 位数，并且它的每个数位上的数字都是不同的，
    并且它平方后的所有数位上都不出现组成它自身的数字。

    具有这样特点的 6 位数还有一个，请你找出它！

    (再归纳一下筛选要求：)
    (6 位正整数；)
    (每个数位上的数字不同；)
    (其平方数的每个数位不含原数字的任何组成数位。)
 */

/**
 * https://www.lanqiao.cn/problems/712/learning/
 */
public class 排它平方数 {
    public static void main(String[] args) {
        Map<Integer, Integer> m1;
        Map<Integer, Integer> m2;

        for (int i = 100000; i < 1000000; i++) {
            m1 = new HashMap<>();
            int temp = i;
            boolean mark = false;
            int len = String.valueOf(temp).length();
            /* 查重 */
            for (int j = 0; j < len; j++) {
                if (m1.containsValue(2)) {
                    mark = true;
                    break;
                }
                int mod = temp % 10;
                temp /= 10;
                if (!m1.containsKey(mod)) {
                    m1.put(mod, 1);
                } else {
                    m1.put(mod, m1.get(mod) + 1);
                }
            }

            if (!mark) {
                long cpi = (long) i * i;
                m2 = new HashMap<>();
                len = String.valueOf(cpi).length();
                for (int j = 0; j <= len; j++) {
                    int mod = (int) (cpi % 10);
                    cpi /= 10;
                    if (!m2.containsKey(mod)) {
                        m2.put(mod, 1);
                    } else {
                        m2.put(mod, m2.get(mod) + 1);
                    }
                }
                /**
                 * https://blog.csdn.net/u013408863/article/details/109722230
                 */
                HashSet<Integer> sTemp = new HashSet<>(m1.keySet());
                sTemp.retainAll(m2.keySet());
                if (sTemp.size() == 0) {
                    System.out.println(i);
                }
            }
        }
    }
}
