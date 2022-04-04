package com.lujun61.original.t4;

import java.util.HashSet;
import java.util.Set;

/**
 * @description 不明确的a * b * ...... * n = res的乘法形式。除了回溯；还有暴力（未知数越少，越简单）。
 *              暴力：找出res的所有因数，将这些因数进行暴力枚举
 * @author Jun Lu
 * @date 2022-03-29 21:26:45
 */
public class 货物摆放 {
    public static void main(String[] args) {
        long num = 2021041820210418L;

        Set<Long> s = new HashSet<>();   //利用set集合去重的功能
        long ch = (long) Math.sqrt(num);  //缩小遍历范围
        for (long i = 1; i <= ch; i++) {  //将num的所有因数存放到Set集合当中
            if (num % i == 0) {
                s.add(num / i);
                s.add(i);
            }
        }

        int res = 0;
        Long[] array = s.toArray(new Long[0]);
        for (Long aLong : array) {
            for (Long aLong1 : array) {
                for (Long aLong2 : array) {
                    if (aLong * aLong1 * aLong2 == num) {
                        res++;
                    }
                }
            }
        }
        System.out.println(res);
    }








}
