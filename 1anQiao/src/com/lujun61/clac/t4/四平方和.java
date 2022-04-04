package com.lujun61.clac.t4;

import java.util.Scanner;


/*
    四重循环是可以获得结果的(但是超时了)

    所以，最后一个循环，将它改为判断，判断它开方后是否为整数  【注意这个小例子：12.010012  !=  12】
 */
public class 四平方和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //i < j < k < sqrt(fourSqrt)
        for (int i = 0; i <= Math.sqrt(n); i++) {
            for (int j = i; j <= Math.sqrt(n - i * i); j++) {
                for (int k = j; k <= Math.sqrt(n - i * i - j * j); k++) {
                    // 使用判断条件减少一层循环
                    int fourSqrt = n - i * i - j * j - k * k;
                    if (Math.sqrt(fourSqrt) == (int) Math.sqrt(fourSqrt)) {  //如果开方为整数，则为正确结果
                        System.out.println(i + " " + j + " " + k + " " + (int) Math.sqrt(fourSqrt));
                        return;
                    }
                }
            }
        }
    }
}
