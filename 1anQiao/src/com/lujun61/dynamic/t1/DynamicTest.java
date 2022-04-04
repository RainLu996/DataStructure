package com.lujun61.dynamic.t1;


/*

 题目：小明参加了学校的趣味运动会，其中的一个项目是：跳格子

        地上画着一些格子，每个格子里写一个字；如下图

        [从我做起振]
        [我做起振兴]
        [做起振兴中]
        [起振兴中华]

        比赛时从左上角的的"从"字开始，只能横向或纵向跳到相邻的格子里，但不能跳到对角的格子，要求跳到"华"字结束。
        要求跳过的路线刚好是"从我做起振兴中华"这句话，请问小明有几种可能的跳跃路线
*/
public class DynamicTest {
    static int ans = 0;

    public static void main(String[] args) {

        System.out.println(106 * 19);
        dfs(0, 0);
        System.out.println(ans);

    }

    /**
     * 方法一
     */
    private static void dfs(int i, int j) {
        if (i == 3 && j == 4) {
            ans++;
        }
        if (i > 3 || j > 4) {
            return;
        }
        dfs(i + 1, j);//向下走
        dfs(i, j + 1);//向右走
    }


    /**
     * 方法二
     */
    private static void dynamic() {
        int[][] arr = new int[4][5];//注意是四列五纵
        for (int i = 0; i < 5; i++) {
            arr[0][i] = 1;
        }
        for (int i = 0; i < 4; i++) {
            arr[i][0] = 1;
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 5; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];//状态转移方程
            }
        }
        System.out.println(arr[3][4]);//35种
    }
}
