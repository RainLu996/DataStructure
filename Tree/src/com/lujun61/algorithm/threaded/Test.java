package com.lujun61.algorithm.threaded;

public class Test {
    public static void main(String[] args) {
        ThreadedNode root = new ThreadedNode(1, "aaa");
        ThreadedNode node_1 = new ThreadedNode(3, "bbb");
        ThreadedNode node_2 = new ThreadedNode(6, "ccc");
        ThreadedNode node_3 = new ThreadedNode(8, "ddd");
        ThreadedNode node_4 = new ThreadedNode(10, "eee");
        ThreadedNode node_5 = new ThreadedNode(14, "fff");

        //非线索化二叉树
        root.setLeft(node_1);
        root.setRight(node_2);
        node_1.setLeft(node_3);
        node_1.setRight(node_4);
        node_2.setLeft(node_5);

        //将非线索化二叉树转化为线索化二叉树
        ThreadedBinaryTree thread = new ThreadedBinaryTree();
        thread.setRoot(root);
        thread.ThreadedTree();

        thread.midTraverse();
    }
}
