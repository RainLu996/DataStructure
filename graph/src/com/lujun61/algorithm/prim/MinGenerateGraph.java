package com.lujun61.algorithm.prim;

import java.util.Arrays;

/**
 * @description 最小生成树
 * @author Jun Lu
 * @date 2022-03-31 19:26:07
 */

/*
    最小生成树:
        最小生成树(Minimum Cost Spanning Tree),简称MST,给定一个带权的左向连接通图,
        如何选取一颗生成树,使树上所有边上权的总和为最小,这叫最小生成树,N个顶点,一定有N-1条边,包含全部顶点,N-1条边都在图中
 */
public class MinGenerateGraph {
    private int vertexNum;  //顶点个数
    private char[] vertex;  //顶点
    private int[][] edges;  //邻接矩阵

    public MinGenerateGraph() {
    }

    public MinGenerateGraph(int vertexNum) {
        this.vertexNum = vertexNum;
        this.vertex = new char[this.vertexNum];
        this.edges = new int[this.vertexNum][this.vertexNum];
    }


    /**
     * @param vertexNum 顶点个数
     * @param vertex    矩阵顶点
     * @param edges     邻接矩阵
     * @description 创建一个连通图
     * @author Jun Lu
     * @date 2022-03-31 16:31:53
     */
    public void createGraph(int vertexNum, char[] vertex, int[][] edges) {
        if (vertexNum >= 0) {
            System.arraycopy(vertex, 0, this.vertex, 0, vertexNum);
            System.arraycopy(edges, 0, this.edges, 0, vertexNum);
        }
    }


    /**
     * @description 遍历输出领接矩阵
     * @author Jun Lu
     * @date 2022-03-31 18:27:50
     */
    public void printGraph() {
        for (int[] ints : edges) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * @param start 起始结点
     * @description 普利姆算法
     * @author Jun Lu
     * @date 2022-03-31 18:03:49
     */
    public void prim(int start) {
        boolean[] isUsed = new boolean[this.vertexNum];
        isUsed[start] = true;


        for (int i = 0; i < this.vertexNum - 1; i++) { /* n个顶点的图，生成具有n - 1条边的最小生成树 */
            int x = -1, y = -1;
            int flag = 10000;  //初始值为 10000，代表顶点权值的“无穷大”

            for (int j = 0; j < this.vertexNum; j++) { /* 条件一：j顶点被选中过 */
                for (int k = 0; k < this.vertexNum; k++) {  /* 条件二：k顶点未被选中过 */
                    /* 条件三：满足前两个条件的前提下，当前结点的权值小于“无穷大”值，以及小于与j顶点连接的其它顶点 */
                    if (isUsed[j] && !isUsed[k] && this.edges[j][k] < flag) {
                        flag = this.edges[j][k];  //更新最小权值顶点
                        x = j;
                        y = k;
                    }
                }
            }

            /* 输出此条最小路径 */
            System.out.println(this.vertex[x] + " ----> " + this.vertex[y] + " = " + flag);

            //标记当前结点已经被访问
            isUsed[y] = true;
        }
    }
}
