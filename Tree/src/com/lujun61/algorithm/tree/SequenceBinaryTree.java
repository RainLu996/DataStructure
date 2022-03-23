package com.lujun61.algorithm.tree;


/**
 * @description 顺序存储二叉树
 * @author Jun Lu
 * @date 2022-03-01 22:30:46
 */
public class SequenceBinaryTree {
    public int[] arrayTree;

    public SequenceBinaryTree() {
    }

    public SequenceBinaryTree(int[] arrayTree) {
        this.arrayTree = arrayTree;
    }

    /**
     * 前序遍历‘顺序存储’的二叉树
     */
    public void preTraverse(int nodeIndex) {
        if (this.arrayTree == null || this.arrayTree.length == 0) {
            System.out.println("此二叉树为空！");
            return;
        }

        System.out.println(this.arrayTree[nodeIndex]);

        /**
         * 顺序二叉树向左遍历
         */
        if ((nodeIndex * 2 + 1) < this.arrayTree.length) {
            this.preTraverse(nodeIndex * 2 + 1);
        }

        /**
         * 顺序二叉树向右遍历
         */
        if ((nodeIndex * 2 + 2) < this.arrayTree.length) {
            this.preTraverse(nodeIndex * 2 + 2);
        }
    }
}