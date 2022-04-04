package com.lujun61.algorithm.graph;

public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        String[] vert = {"A", "B", "C", "D", "E"};

        for (String ele : vert) {
            graph.insertVertex(ele);
        }

        graph.insertEdges(0, 1, 1);
        graph.insertEdges(0, 2, 1);
        graph.insertEdges(1, 2, 1);
        graph.insertEdges(1, 3, 1);
        graph.insertEdges(1, 4, 1);

        graph.printMatrix();

        graph.dfs();

        System.out.println();

        graph.bfs();
    }
}
