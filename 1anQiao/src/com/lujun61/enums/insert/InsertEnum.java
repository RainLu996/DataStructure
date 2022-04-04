package com.lujun61.enums.insert;

public class InsertEnum {
    public static void main(String[] args) {
        for (int i = 1; i <= 46; i++) {
            for (int j = i + 2; j <= 48; j++) {
                int sum = i * (i + 1) + j * (j + 1);
                for (int k = 1; k <= 49; k++) {
                    if (k != i && k != i + 1 && k != j && k != j + 1) {
                        sum += k;
                    }
                }
                if (sum == 2015) {
                    System.out.println(i);
                }
            }
        }
    }

/*  无效写法
    public static void main(String[] args) {
        for (int i = 1; i <= 46; i++) {
            for (int j = i + 1; j <= 47; j++) {
                int sum = i * j + (i + 2) * (j + 2);
                for (int k = 1; k <= 49; k++) {
                    if (k != i && k != i + 2 && k != j && k != j + 2) {
                        sum += k;
                    }
                }
                if (sum == 2015) {
                    System.out.println(i);
                }
            }
        }
    }*/















}
