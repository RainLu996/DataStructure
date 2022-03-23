package com.lujun61.dataStructure.stack;

import java.util.Scanner;

/**
 * 通过数组模拟栈来判断回文
 */
public class CircleTxt {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String val = s.next();
        System.out.println(judgeCircleTxt(val) ? "此数据是回文" : "此数据不是回文");
    }

    public static boolean judgeCircleTxt(String val) {
        //初始化栈对象
        ArrayStack arrayStack = new ArrayStack(10);

        //获取用户输入的字符串长度
        int inLength = val.length();

        //将输入的字符逐个压入数组栈中
        for (int i = 0; i < inLength; i++) {
            arrayStack.push(val.charAt(i));
        }

        //拼接弹栈后的所得的字符串
        StringBuilder builder = new StringBuilder();
        int currentLength = arrayStack.length();//为什么不直接写入循环呢？因为此值不是固定的！！！每POP一次就会改变（减一）。
        if (!arrayStack.isEmpty()) {
            for (int i = 0; i < currentLength; i++) {
                builder.append(arrayStack.pop());
            }
        }
        return builder.toString().equals(val);
    }
}
