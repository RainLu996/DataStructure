package com.lujun61.leetcode.t2;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 */
public class 杨辉三角2 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ta = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {   //行
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

        return ta.get(rowIndex);
    }
}
