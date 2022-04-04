package com.lujun61.clac.t1;

/*
    有一堆煤球，堆成三角棱锥体。具体：

    第一层放1个，第二层3个，第三层6个，第四层10个，.............如果一共有100层，共有多少个煤球？
 */

/**
 * 找规律
 */
public class 煤球数目 {
    public static void main(String[] args) {
        int count = 1;
        int cur = count;  //当前层煤球个数
        for (int i = 2; i <= 100; i++) {
            cur += i;
            count += cur;
        }
        System.out.println(count);
    }
}
