package com.lujun61.original.t3;

import java.util.HashMap;

/**
 * 判断两个浮点数是否相等：考虑误差
 *     如何考虑：看两个浮点数之间的差值是否大于1e-8
 */
public class 直线 {
    public static void main(String[] args) {
        HashMap<Double, Double> p = new HashMap<>();


        int index = 0;
        for (int x1 = 0; x1 < 20; x1++) {
            for (int x2 = 0; x2 < 20; x2++) {
                for (int y1 = 0; y1 < 21; y1++) {
                    for (int y2 = 0; y2 < 21; y2++) {
                        if (x1 != x2) {
                            double k = (double) (y2 - y1) / (x2 - x1);   //斜率
                            double b = (double) y2 - k * x2;             //截距
                            p.put(k, b);
                            index++;
                        }
                    }
                }
            }
        }

        int count = 0;
        /* 判断不同直线 */

        System.out.println(index);
        Double[] keys = p.keySet().toArray(new Double[0]);
        Double[] vals = p.values().toArray(new Double[0]);



        System.out.println(keys.length);
        System.out.println(vals.length);

        for (int i = 1; i < index; i++) {
            if (Math.abs(keys[i] - keys[i - 1]) > 1e-8 || Math.abs(vals[i] - vals[i - 1]) > 1e-8) {
                count++;
            }
        }

        System.out.println(count + 20);
    }
}
