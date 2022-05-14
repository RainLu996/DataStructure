package com.lujun61.violence;

public class ViolenceMatch {
    public static void main(String[] args) {

        String s1 = "abcd";
        String s2 = "cd";
        System.out.println(violenceMatch(s1, s2));

    }

    /**
     * @param str1 主串
     * @param str2 副串
     * @return int 副串在主串中第一次出现的元素下标
     * @description 暴力匹配字符串
     * @author Jun Lu
     * @date 2022-05-14 11:03:11
     */
    public static int violenceMatch(String parent, String child) {

        char[] c1 = parent.toCharArray();
        char[] c2 = child.toCharArray();

        int len1 = c1.length;
        int len2 = c2.length;

        int index1 = 0, index2 = 0;
        while (index1 < len1 && index2 < len2) {
            if (c1[index1] == c2[index2]) {
                index1++;
                index2++;
            } else {
                // 长串下标向前进1，副串下标置位0
                index1 = index1 - index2 + 1;
                index2 = 0;
            }
        }

        // 匹配成功
        if (index2 == len2) {
            return index1 - index2;
        } else {
            return -1;
        }
    }
}
