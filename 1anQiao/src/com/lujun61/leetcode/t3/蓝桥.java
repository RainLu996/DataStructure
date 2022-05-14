package com.lujun61.leetcode.t3;

import java.util.ArrayList;
import java.util.List;

public class 蓝桥 {
    public static void main(String[] args) {
        List<List<Integer>> ta = new ArrayList<>();

        for (int i = 0; i <= 1000000; i++) {   //行
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {  //列
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(ta.get(i - 1).get(j - 1) + ta.get(i - 1).get(j));
                }
            }
            ta.add(temp);
        }

        System.out.println(4);
    }
}
