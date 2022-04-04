package com.lujun61.algorithm.prim;

public class PrimTest {
    public static void main(String[] args) {
        char[] data = {'A','B','C','D','E','F','G'};

        int[][] weight = {
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},
        };

        int verxs = data.length;

        MinGenerateGraph prim = new MinGenerateGraph(verxs);
        prim.createGraph(verxs, data, weight);

        prim.printGraph();
        prim.prim(0);
    }
}
