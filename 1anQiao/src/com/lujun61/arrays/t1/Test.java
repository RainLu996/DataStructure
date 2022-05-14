package com.lujun61.arrays.t1;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Integer[] array = {1, 23, 5555, 22, 5656, 12};

        /**
         * 使用前提：需要使用包装类数组！！！
         */
        //Arrays.sort(array , (a, b) -> Integer.compare(a, b));   //升序
        Arrays.sort(array , (a, b) -> Integer.compare(b, a));   //降序

        System.out.println(Arrays.toString(array));

    }
}
