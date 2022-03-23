package com.lujun61.simulate;

import java.util.Arrays;

public class SimulateTest {
    public static void main(String[] args) {
        算式问题();

        含有n个约数的整数();
    }


    /*
        看这个算式：

        ☆☆☆ + ☆☆☆ = ☆☆☆

        如果每个五角星代表 1 ~ 9 的不同的数字。

        这个算式有多少种可能的正确填写方法？
     */

    /**
     * 循环模拟（）
     * if判断
     * 按照条件进行特殊操作
     */
    public static void 算式问题() {
        int count = 0;
        for (int i = 123; i <= 987; i++) {
            for (int j = 123; j <= 987; j++) {
                int and = i + j;
                String all = "" + i + j + and;
                char[] numArr = all.toCharArray();
                Arrays.sort(numArr);
                String res = String.valueOf(numArr);
                if ("123456789".equals(res)) count++;
            }
        }
        System.out.println(count);
    }

/*    public static void main(String[] args) {
        int sum = 0;
        for (int i = 123; i <= 987; i++) {
            for (int j = 123; j <= 987; j++) {
                int k = i + j;
                String a = "" + i + j + k;
                char[] b = a.toCharArray();
                Arrays.sort(b);
                String s = String.valueOf(b);
                if (s.equals("123456789") && i + j == k) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }*/


    /*
        学习了约数后，小明对于约数很好奇，他发现，给定一个正整数 t，总是可以找到含有 t 个约数的整数。
        小明对于含有 t 个约数的 最小数 非常感兴趣，并把它定义为 St。

        例如 S1=1,S2=2,S3=4,S4=6，⋅⋅⋅ 。

        现在小明想知道，当 t=100 时，St100是多少？即 S100 是多少？
     */
    public static void 含有n个约数的整数() {
        for (int i = 100; i < 100000; i++) {
            int count = 0;
            int j = 1;
            for (; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 100) {
                System.out.println(j);
                break;
            }
        }
    }
}
