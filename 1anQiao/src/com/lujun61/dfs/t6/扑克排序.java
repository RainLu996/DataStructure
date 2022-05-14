package com.lujun61.dfs.t6;

import java.util.HashSet;

public class 扑克排序 {
    static HashSet<String> res = new HashSet<>();
    static boolean[] used = new boolean[8];

    public static void main(String[] args) {
        char[] eles = {'A', 'A', '2', '2', '3', '3', '4', '4'};
        dfs(0, eles);

        for (String s : res) {
            System.out.println(s);
        }
    }

    private static void dfs(int depth, char[] eles) {
        if (depth == eles.length) {
            String str = new String(eles);
            if (check(str)) {
                res.add(str);
            }
        }

        for (int i = depth; i < eles.length; i++) {
            char temp = eles[depth];
            eles[depth] = eles[i];
            eles[i] = temp;

            dfs(depth + 1, eles);

            temp = eles[depth];
            eles[depth] = eles[i];
            eles[i] = temp;
        }
    }

    private static boolean check(String str) {
        /* 注意API用法！！！ */
        return str.lastIndexOf('A') - str.indexOf('A') == 2 &&
                str.lastIndexOf('2') - str.indexOf('2') == 3 &&
                str.lastIndexOf('3') - str.indexOf('3') == 4 &&
                str.lastIndexOf('4') - str.indexOf('4') == 5;
    }
}
