package com.lujun61.algorithm.bubble;

/**
 * @description 不使用第三个数字，完成两个数据的交换
 * @author Jun Lu
 * @date 2021-08-17 16:04:19
 */
public class Swap {
    void swap1(int a,int b)
    {
        a = a + b;
        b = a - b;
        a = a - b;
    }
    void swap2(int a,int b)
    {
        a = a * b;
        b = a / b;
        a = a / b;
    }
    void swap3(int a,int b)
    {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
