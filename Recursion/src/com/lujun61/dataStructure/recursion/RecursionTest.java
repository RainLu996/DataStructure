package com.lujun61.dataStructure.recursion;

/**
 * @Author: 陆俊
 * @Date：2021/8/15 - 21:25
 * @Description：com.lujun61.dataStructure.recursion
 */


public class RecursionTest {
    public static void main(String[] args) {
        //设置(初始化)迷宫格-------构建地基
        int row = 8;
        int column = 7;
        int[][] map = new int[row][column];

        //创建迷宫墙
        buildMap(row, column, map);
        System.out.println("原始迷宫：");
        traverse(map);

        isRun(map, 1, 1);
        System.out.println("小球走后的迷宫：");
        traverse(map);
    }


    /**
     * 遍历二维数组的方法
     * @param arrays 需要遍历输出的二维数组
     */
    public static void traverse(int[][] arrays) {
        for (int[] singleArray :
                arrays) {
            for (int ele:
                    singleArray) {
                System.out.print(ele + "\t");
            }
            System.out.println();
        }
    }


    /**
     * 构建迷宫围墙
     * @param row 迷宫行数
     * @param column 迷宫列数
     * @param map 创建的迷宫数组
     */
    public static void buildMap(int row, int column, int[][] map) {
        //设置上下两堵墙
        for (int i = 0; i < row; i++) {
            map[i][0] = 1;
            map[i][column - 1] = 1;
        }

        //设置左右两堵墙
        for (int i = 0; i < column; i++) {
            map[0][i] = 1;
            map[row - 1][i] = 1;
        }

        //设置障碍墙
        map[3][1] = 1;
        map[3][2] = 1;
    }


    /**
     * 小球路线分析
     * @param map 传进来一个地图
     * @param row 小球走的横坐标
     * @param column 小球走的纵坐标
     * @return 如果小球能将当前的点走通，则返回true；否则返回false
     */
    public static boolean isRun(int[][] map, int row, int column) {
        if (map[6][4] == 2) {//终点坐标（6,4）
            return true;
        } else {
            if (map[row][column] == 0) {//“==0”时还没有走过该点
                map[row][column] = 2;//“==2”时就表示已经将该点走过了，而且不能回头走第二次

                //继续判断上下左右是否能走
                if (isRun(map, row - 1, column)) {//上
                    return true;
                } else if (isRun(map, row + 1, column)) {//下
                    return true;
                } else if (isRun(map, row, column - 1)) {//左
                    return true;
                } else if (isRun(map, row, column + 1)) {//右
                    return true;
                } else {
                    map[row][column] = 3;//“==3”时表示上下左右走不通（都不为0）
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
