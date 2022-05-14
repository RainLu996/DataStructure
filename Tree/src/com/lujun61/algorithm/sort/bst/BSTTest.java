package com.lujun61.algorithm.sort.bst;

import com.lujun61.algorithm.sort.Node;

public class BSTTest {
    public static void main(String[] args) {


        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};

        BST binarySortTree = new BST();
        for (int j : arr) {
            binarySortTree.addNode(new Node(j));
        }

        System.out.println("删除前");
        binarySortTree.midTraverse();
        System.out.println(binarySortTree.getRoot());

        binarySortTree.deleteNode(7);
        System.out.println(binarySortTree.getRoot());
        System.out.println();
        binarySortTree.deleteNode(2);
        System.out.println(binarySortTree.getRoot());
        binarySortTree.deleteNode(5);
        System.out.println(binarySortTree.getRoot());
        binarySortTree.deleteNode(10);
        System.out.println(binarySortTree.getRoot());
        binarySortTree.deleteNode(1);
        System.out.println(binarySortTree.getRoot());

        System.out.println("删除后");
        binarySortTree.midTraverse();
    }
}
