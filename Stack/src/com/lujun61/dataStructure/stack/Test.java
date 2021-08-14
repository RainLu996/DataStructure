package com.lujun61.dataStructure.stack;

/**
 * 将StringBuilder类转换成String类
 */
public class Test {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("l");
        builder.append("l");
        builder.append("l");
        System.out.println("lll".equals(builder));//false
        System.out.println(builder.toString().equals("lll"));//true
    }
}
