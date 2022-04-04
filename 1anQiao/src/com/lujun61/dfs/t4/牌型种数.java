package com.lujun61.dfs.t4;


/*
    小明被劫持到X赌城，被迫与其他3人玩牌。

    一副扑克牌（去掉大小王，共52张），均匀发给4个人，每个人13张

    这时，小明脑子里突然想到一个问题：

    如果不考虑花色，只考虑点数，也不考虑自己得到的牌的先后顺序，自己手里能拿到的初始牌型组合一共有多少种呢？
 */
public class 牌型种数 {
    static int ans = 0;  //答案数
    static int sum = 0;  //手牌数（不能大于13张牌）

    public static void main(String[] args) {
        dfs(0);
        System.out.println(ans);//输出答案为3598180
    }

    public static void dfs(int depth) {
        if (depth > 13 || sum > 13) return;   //只有13张牌有选择

        if (sum == 13) {
            ans++;
            return;
        }

        for (int i = 0; i <= 4; i++) {   //每种花色的牌都可以被选择0~4次
            sum += i;
            dfs(depth + 1);
            sum -= i;
        }
    }
}
