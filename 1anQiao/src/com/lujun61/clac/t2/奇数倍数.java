package com.lujun61.clac.t2;

public class 奇数倍数 {
    public static void main(String[] args) {
        for (int i = 2020; i < 100000000; i++) {
            if (i % 2019 == 0 && isAccess(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean isAccess(int i) {
        int len = String.valueOf(i).length();

        int temp = 0;
        int count = 0;
        for (int j = 0; j < len; j++) {
            temp = i % 10;
            i /= 10;

            if (temp % 2 != 0) {
                count++;
            }
        }

        return count == len;
    }
}
