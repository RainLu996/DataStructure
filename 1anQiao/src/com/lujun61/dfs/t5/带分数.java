package com.lujun61.dfs.t5;

public class 带分数 {
    public static void main(String[] args) {

    }
}

/**
 * int num1 = toInt(arr, 0, i);  // "+"前面的一段整数
 * int num2 = toInt(arr, i, j);  // "+"与"/"之间的整数
 * int num3 = toInt(arr, i + j, 9 - i - j);  // "/"后面的整数
 * <p>
 * 100 = 3 + 69258 / 714
 * int num1 = toInt(arr, 0, 1);
 * int num2 = toInt(arr, 1, 5);
 * int num3 = toInt(arr, 1 + 5, 9 - 1 - 5);
 * <p>
 * 100 = 82 + 3546 / 197
 * int num1 = toInt(arr, 0, 2);
 * int num2 = toInt(arr, 2, 4);
 * int num3 = toInt(arr, 2 + 4, 9 - 2 - 4);
 */
