package com.lujun61.math.t1;

public class 纯质数 {
    public static void main(String[] args) {
        int count = 4;

        for (long i = 22; i <= 20210605; i++) {
            String temp = String.valueOf(i);

            if (!(temp.contains("0") || temp.contains("1") || temp.contains("4") || temp.contains("6") || temp.contains("8") || temp.contains("9"))) {
                if (isPrime(i)) count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isPrime(long num) {
        boolean mark = true;

        for (long i = 2; i < num; i++) {
            if (num % i == 0) {
                mark = false;
                break;
            }
        }

        return mark;
    }


}
