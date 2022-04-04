package com.lujun61.leetcode.t1;

import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode-cn.com/problems/pascals-triangle/
 */
public class 杨辉三角 {
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);

        for (List<Integer> list : generate) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ta = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {   //行
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

        return ta;
    }
}
