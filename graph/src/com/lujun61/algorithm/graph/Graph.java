package com.lujun61.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    //顶点元素
    private ArrayList<String> vertexList;

    //顶点个数
    private Integer vertexNum;

    //邻接矩阵
    private int[][] edges;

    //图中边的条数
    private int edgesNum;

    //顶点是否被遍历过
    private boolean[] isSelected;

    public Graph() {
    }

    public Graph(int size) {
        this.vertexList = new ArrayList<>(size);
        this.edges = new int[size][size];
        this.isSelected = new boolean[size];
        this.vertexNum = size;
    }

    /**
     * 插入顶点
     * @param vertex 顶点
     */
    public void insertVertex(String vertex) {
        this.vertexList.add(vertex);
    }

    /**
     * @param x 横坐标
     * @param y 纵坐标
     * @param weight 权值：0/1
     * @description 插入图边（给邻接矩阵赋值）
     * @author Jun Lu
     * @date 2022-03-12 10:45:05
     */
    public void insertEdges(int x, int y, int weight) {
        //例如：A<——>B
        this.edges[x][y] = weight;
        this.edges[y][x] = weight;

        //添加边的个数
        this.edgesNum++;
    }

    /**
     * 获取边的数量
     */
    public int getEdgesNum() {
        return this.edgesNum;
    }

    /**
     * 获取顶点的权值
     */
    public int getWeight(int x, int y) {
        return this.edges[x][y];
    }

    /**
     * 打印整个邻接矩阵
     */
    public void printMatrix() {
        for (int[] edge : this.edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    /**
     * @param index 给定顶点的索引
     * @return int 当前顶点的下一个邻接点（纵坐标）
     * @description 给定顶点，查找当前顶点的下一个邻接点。存在则返回存在位置，不存在则返回-1
     * @author Jun Lu
     * @date 2022-03-12 14:30:05
     */
    public int getNextVertex(int index) {
        for (int i = 0; i < this.vertexNum; i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param x 横坐标
     * @param y 纵坐标
     * @return int 当前顶点的下一个邻接点（纵坐标）
     * @description 给定坐标，查找当前顶点的下一个邻接点。存在则返回存在位置，不存在则返回-1
     * @author Jun Lu
     * @date 2022-03-12 15:59:02
     */
    public int getNextVertex(int x, int y) {
        for (int i = y + 1; i < this.vertexNum; i++) {
            if (edges[x][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param index 给定顶点的索引
     * @return java.lang.String 返回顶点的值
     * @description 给定顶点的索引，返回顶点的值
     * @author Jun Lu
     * @date 2022-03-12 17:56:21
     */
    public String getVertexValue(int index) {
        return this.vertexList.get(index);
    }

    /**
     * @description 深度优先搜索
     * @author Jun Lu
     * @date 2022-03-12 17:49:09
     */
    public void dfs(boolean[] isSelected, int index) {
        System.out.print(this.getVertexValue(index));   //访问输出
        isSelected[index] = true;  //访问输出一个，就标记一个

        //查找index的第一个邻接顶点
        int y = this.getNextVertex(index);
        while (y != -1) {
            if (!isSelected[y]) { //如果没有被访问过
                dfs(isSelected, y);
            }
            y = this.getNextVertex(index, y); //如果被访问过
        }
    }

    /**
     * @description 深度优先搜索
     * @author Jun Lu
     * @date 2022-03-12 17:49:09
     */
    public void dfs() {
        for (int i = 0; i < this.vertexNum; i++) {
            if (!this.isSelected[i]) {
                dfs(this.isSelected, i);
            }
        }
    }

    /**
     * @description 广度优先搜索
     * @author Jun Lu
     * @date 2022-03-12 17:49:09
     */
    public void bfs(boolean[] isSelected, int index) {
        //队列中的头结点
        Integer head;

        //当前结点的第一个邻接结点
        int first;

        /*
            类似于一个 9的过程，广度优先遍历（Breadth-First-Search）需要使用一个队列以保持访问过的结点的顺序，
            以便按这个顺序来访问这些结点的邻接结点
        */
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print(this.getVertexValue(index));
        isSelected[index] = true;
        queue.addLast(index);

        while (!queue.isEmpty()) {
            head = queue.removeFirst();
            first = this.getNextVertex(head);
            while (first != -1) {
                if (!isSelected[first]) {
                    System.out.print(this.getVertexValue(first));
                    isSelected[first] = true;
                    queue.add(first);
                }
                first = this.getNextVertex(index, first);
            }
        }
    }

    /**
     * @description 广度优先搜索
     * @author Jun Lu
     * @date 2022-03-12 17:49:09
     */
    public void bfs() {
        for (int i = 0; i < this.vertexNum; i++) {
            bfs(this.isSelected, i);
        }
    }
}
