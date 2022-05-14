package com.lujun61.dynamic.t3;

import java.util.Arrays;

// TODO : 等待回头再学
/*tocyjkdzcieoiodfpbgcncsrjbhmugdnojjddhllnofawllbhfiadgdcdjstemphmnjihecoapdjjrprrqnhgccevdarufmliqijgihhfgdcmxvicfauachlifhafpdccfseflcdgjncadfclvfmadvrnaaahahndsikzssoywakgnfjjaihtniptwoulxbaeqkqhfwl*/
public class 序列 {
    public static int[] dp;

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        String s = sc.next();*/

        String s = "lanqiao";

        char[] num = s.toCharArray();
        dp = new int[s.length()];
        Arrays.fill(dp, 1);  //将dp数组用1填满（初始化操作）

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (num[j] < num[i]) {
                    dp[i] += dp[j];
                }
                if (num[j] == num[i]) {
                    dp[i] -= dp[j];
                }
            }
        }
        int res=0;
        for (int i = 0; i < dp.length; i++) {
            res+=dp[i];
        }
        System.out.println(res);
    }
}
