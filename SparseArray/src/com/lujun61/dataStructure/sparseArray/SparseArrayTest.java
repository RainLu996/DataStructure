package com.lujun61.dataStructure.sparseArray;

/**
 * @Author: 陆俊
 * @Date：2021/8/15 - 19:40
 * @Description：com.lujun61.dataStructure.sparseArray
 */


public class SparseArrayTest {
    public static void main(String[] args) {
        //创建一个棋盘
        int row = 11;//行
        int column = 11;//列
        int[][] arrays = new int[row][column];
        arrays[1][2] = 1;//有效数据
        arrays[2][4] = 2;//有效数据


        //计算棋盘中的有效数据
        int count = validate(arrays);
        traverse(arrays);//遍历arrays数组

        //创建一个稀疏数组用来“压缩”棋盘
        //给稀疏数组的第一行赋值
        int[][] sparseArray = new int[count +1][3];
        sparseArray[0][0] = row;
        sparseArray[0][1] = column;
        sparseArray[0][2] = count;
        traverse(sparseArray);//遍历初始状态下的稀疏数组


        //把有效数据存放进稀疏数组
        loadData(row, column, arrays, sparseArray);
        traverse(sparseArray);//遍历赋值后的稀疏数组

        //还原数组
        int[][] oldArray = reduction(sparseArray, count);
        traverse(oldArray);
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
     * 统计原数组中的有效数据
     * @param arrays 原数组
     * @return 原数组中的有效数据
     */
    public static int validate(int[][] arrays) {
        int count = 0;
        for (int[] singleArray :
                arrays) {
            for (int ele:
                    singleArray) {
                if (ele != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 将有效数据的信息传入稀疏数组中
     * @param row 原始二维数组的行数
     * @param column 原始二维数组的列数
     * @param sourceArrays 原始二维数组
     * @param sparseArray 目标稀疏数组
     */
    public static void loadData(int row, int column, int[][] sourceArrays, int[][] sparseArray) {
        int index = 0;//等价于一个定位指针
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (sourceArrays[i][j] != 0) {
                    sparseArray[++index][0] = i;//存放行信息
                    sparseArray[index][1] = j;//存放列信息
                    sparseArray[index][2] = sourceArrays[i][j];
                }
            }
        }
    }

    /**
     * 还原数组
     * @param sparseArray 稀疏数组
     * @param count 有效数据个数
     * @return 返回还原完成的数组
     */
    public static int[][] reduction(int[][] sparseArray, int count) {
        int[][] originalArray = new int[sparseArray[0][0]][sparseArray[0][1]];//初始化一个存放原始数据的“还原数组”
        for (int i = 1; i <= count; i++) {
            originalArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return originalArray;
    }
}