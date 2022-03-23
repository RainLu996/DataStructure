package com.lujun61.algorithm.tree;

public class Test {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        Node root = new Node(0, "aaa");
        Node node_1 = new Node(1, "bbb");
        Node node_2 = new Node(2, "ccc");
        Node node_3 = new Node(3, "ddd");
        Node node_4 = new Node(4, "ggg");
        tree.setRoot(root);

        root.setLeft(node_1);
        node_1.setLeft(node_2);
        root.setRight(node_3);
        node_3.setRight(node_4);

        Node p = root.preSearchNodeById(2);
        Node m = root.midSearchNodeById(2);
        Node po = root.postSearchNodeById(2);
        System.out.println(p);
        System.out.println(m);
        System.out.println(po);

        System.out.println("前序遍历：");
        tree.preTraverse();

        System.out.println("中序遍历：");
        tree.midTraverse();

        System.out.println("后序遍历：");
        tree.postTraverse();

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

        int[] array = {1, 3, 2, 6, 343, 5, 4};
        SequenceBinaryTree tree1 = new SequenceBinaryTree(array);
        tree1.preTraverse(0);
    }
}
