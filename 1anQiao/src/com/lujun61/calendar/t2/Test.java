package com.lujun61.calendar.t2;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        int num = 20200131;

        String sNum = String.valueOf(num);
        String year = sNum.substring(4, 6);
        System.out.println(year);
        int i = Integer.parseInt(year);
        System.out.println(i);
        System.out.println(Integer.valueOf(year));

        System.out.println("---------------");

        Map<Integer, Integer> m = new HashMap<>();
        m.put(1, 2);
        m.put(2, 2);

        System.out.println(m.size());


        System.out.println("---------------");

        int[] array = {1, 2, 3};
        //System.out.println(array[-1]);  ArrayIndexOutOfBoundsException: -1
    }
}
