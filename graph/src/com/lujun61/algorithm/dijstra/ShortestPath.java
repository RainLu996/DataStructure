package com.lujun61.algorithm.dijstra;

public class ShortestPath {
    public static int MaxValue = 100000;

    public static void main(String[] args) {

        //顶点数
        int vertex = 7;
        //边数
        //int edge = 9;

        int[][] matrix = new int[vertex][vertex];

        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                matrix[i][j] = MaxValue;
            }
        }

        matrix[0][1] = 6;
        matrix[1][2] = 5;
        matrix[0][3] = 2;
        matrix[3][1] = 7;
        matrix[3][4] = 5;
        matrix[1][5] = 3;
        matrix[5][2] = 3;
        matrix[4][5] = 5;
        matrix[4][6] = 1;

        int source = 1;

        dijstra(matrix, source);
    }

    /**
     * 迪杰斯特拉算法
     *
     * @param matrix
     * @param source
     */
    public static void dijstra(int[][] matrix, int source) {
        //最短路径长度
        int[] shorttest = new int[matrix.length];
        //判断该点最短路径是否求出   0--未被使用过   1--被使用过
        int[] visited = new int[matrix.length];
        //存储输出路径
        String[] path = new String[matrix.length];

        //初始化输出路径
        for (int i = 0; i < matrix.length; i++) {
            path[i] = source + "-->" + i;
        }

        shorttest[source] = 0;
        visited[source] = 1;

        //有n个结点时，根结点到目标结点一共有n-1条路径
        for (int i = 1; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;

            //循环找出最短路径
            for (int j = 0; j < matrix.length; j++) {
                //j顶点未被选中过，并且source结点到j结点的路径长度为最小值
                if (visited[j] == 0 && matrix[source][j] < min) {
                    min = matrix[source][j];
                    index = j;
                }
            }

            //将所找出的最短路径加入【最短路径的集合】中
            shorttest[index] = min;
            //更改最短状态，如果是1表示已经是最短了，如果是0表示没有找到
            visited[index] = 1;


            //如果index顶点还能 进一步 产生另一条到另一个顶点最短路径，则更新path
            //例如：matrix[0][3]+matrix[3][1]<matrix[0][1]
            for (int m = 0; m < matrix.length; m++) {
                if (visited[m] == 0 && matrix[source][index] + matrix[index][m] < matrix[source][m]) {
                    matrix[source][m] = matrix[source][index] + matrix[index][m];//matrix[0][1] = matrix[0][3]+matrix[3][1]
                    path[m] = path[index] + "-->" + m;
                }
            }
        }


        //打印最短路径
        for (int i = 0; i < matrix.length; i++) {
            if (i != source) {
                if (shorttest[i] == MaxValue) {
                    System.out.println(source + "到" + i + "不可达");
                } else {
                    System.out.println(source + "到" + i + "的最短路径为:" + path[i] + ",最短距离是:" + shorttest[i]);
                }
            } else {
                System.out.println(source + "到" + i + "的最短路径为:" + source + "-->" + i + ",最短距离是:" + shorttest[i]);
            }
        }
    }
}
