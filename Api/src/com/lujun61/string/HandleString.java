package com.lujun61.string;

/*
     把abcd....s共19个字母组成的序列重复拼接106次，得到长度为2014的串。

     接下来删除第1个字母（即开头的字母a），以及第3个，第5个等所有奇数位置的字符。
     得到的新串再进行删除奇数位置字母的动作。如此下去，最后只剩下一个字母，请写出该字母。

*/
public class HandleString {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();

        //拼接字符串
        for (int i = 0; i < 106; i++) {
            s.append("abcdefghijklmnopqrs");
        }


        //循环删除字符
        while (s.length() > 1) {
            int len = s.length() / 2;
            if (s.length() % 2 != 0) {   //奇数个元素需要比偶数个元素多删除一个元素
                len++;
            }

            for (int i = 0; i < len; i++) {
                s.deleteCharAt(i);  //由于此API的特性是：删除一个元素后，元素都要前移一位。所以不需要【i += 2】
            }
        }
        System.out.println(s);
    }
}
