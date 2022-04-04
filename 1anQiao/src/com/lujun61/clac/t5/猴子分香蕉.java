package com.lujun61.clac.t5;

public class 猴子分香蕉 {
    public static void main(String[] args) {
        for (int i = 0; ; i++) {
            int temp = i;
            if (temp % 5 == 1) {
                temp = ((temp - 1) / 5) * 4;
                if (temp % 5 == 2) {
                    temp = ((temp - 2) / 5) * 4;
                    if (temp % 5 == 3) {
                        temp = ((temp - 3) / 5) * 4;
                        if (temp % 5 == 4) {
                            temp = ((temp - 4) / 5) * 4;
                            //temp >= 5：如果没有此条件，那么最后一个猴子在分香蕉的时候可能只剩下0根香蕉了
                            if (temp % 5 == 0 && temp >= 5) {
                                System.out.println(i);   //3141
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
