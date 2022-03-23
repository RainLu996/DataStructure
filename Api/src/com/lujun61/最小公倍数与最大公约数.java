package com.lujun61;


public class 最小公倍数与最大公约数 {
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        互质分子分母求和();

        既约分数();
    }

    /*
        如果一个分数的分子和分母的 最大公约数 是 1，这个分数称为既约分数。

        例如，3/4，1/8，7/1 都是既约分数。

        请问，有多少个既约分数，分子和分母都是 1 到 2020 之间的整数（包括 1和 2020）？
     */
    public static void 既约分数() {
        int count = 0;
        for (int i = 1; i <= 2020; i++) {
            for (int j = 1; j <= 2020; j++) {
                if (gcd(i, j) == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    /*
        1/1+1/2+1/4+1/8+⋯

        每项是前一项的一半，如果一共有 20 项,求这个和是多少，结果用分数表示出来。

        类似：3/2，当然，这只是加了前 2 项而已。分子分母要求 互质。
    */

    /**
     * 互质就是说要 约分：用最大公倍数去除每个数即可得到互质的两个数。
     */
    public static void 互质分子分母求和() {
        int up = 1;
        int down = 1;
        for (int i = 2; i <= 20; i++) {
            //直接求和，并将分子分母更新
            down *= 2;
            up += down;
        }
        int gcd = gcd(up, down);
        System.out.println((up / gcd) + "/" + (down / gcd));
    }
}
