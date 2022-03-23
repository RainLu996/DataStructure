package com.lujun61.data;

import java.math.BigInteger;

public class BigData {
    public static void main(String[] args) {
        棋盘放麦子();

        数列求值();
    }


    /*
        你一定听说过这个故事。国王对发明国际象棋的大臣很佩服，问他要什么报酬，
        大臣说：请在第 1个棋盘格放 1 粒麦子，在第 2 个棋盘格放 2 粒麦子，在第 3 个棋盘格放 4 粒麦子，在第 4 个棋盘格放 8 粒麦子，
        ......后一格的数字是前一格的两倍，直到放完所有棋盘格（国际象棋共有 64 格）。

        国王以为他只是想要一袋麦子而已，哈哈大笑。

        当时的条件下无法准确计算，但估算结果令人吃惊：即使全世界都铺满麦子也不够用！

        请你借助计算机准确地计算，到底需要多少粒麦子。
    */

    /**
     * 最后的数据太大，必须使用特殊方法处理
     */
    public static void 棋盘放麦子() {
        BigInteger current = new BigInteger("1");  //当前棋盘中的麦子数
        BigInteger count = new BigInteger("1");    //麦子总数


        for (int j = 1; j <= 63; j++) {
            current = current.multiply(new BigInteger("2"));
            count = count.add(current);
        }
        System.out.println(count);
    }


    /*
        给定数列 1, 1, 1, 3, 5, 9, 17,……从第 4 项开始，每项都是前 3 项的和。

        求第 20190324 项的最后 4 位数字。
     */

    /**
     * 取 最后n位 数字，就不用将整个数字求出返回，那就不涉及精度问题。使用方法只保留最后四位即可
     */
    public static void 数列求值() {
        int a = 1;
        int b = 1;
        int c = 1;

        int res = 0;
        for (int i = 4; i <= 20190324; i++) {
            res = a + b + c;
            if (res > 10000) {
                res %= 10000;
            }
            a = b;
            b = c;
            c = res;
        }
        System.out.println(res);
    }















}
