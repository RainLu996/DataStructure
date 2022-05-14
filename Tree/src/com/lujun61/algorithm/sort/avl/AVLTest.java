package com.lujun61.algorithm.sort.avl;

import com.lujun61.algorithm.sort.Node;

public class AVLTest {
    public static void main(String[] args) {

        AVLTree tree = new AVLTree();

        /*//左旋测试代码
        int[] arr = {4, 3, 6, 5, 7, 8};*/

        /*//右旋测试代码
        int[] arr = {10, 12, 8, 9, 7, 6};*/

        // 双旋测试代码
        int[] arr = {10, 11, 7, 6, 8, 9};


        for (int i = 0; i < arr.length; i++) {
            tree.addNode(new Node(arr[i]));
        }

        tree.midTraverse();

        System.out.println("当前根结点：" + tree.getRoot());
        System.out.println("树的高度：" + tree.getRoot().height());
        System.out.println("树的左子树的高度：" + tree.getRoot().leftHeight());
        System.out.println("树的右子树的高度：" + tree.getRoot().rightHeight());

    }
}
