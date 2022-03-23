package com.lujun61.algorithm.threaded;

public class ThreadedBinaryTree {
     private ThreadedNode root;
     private ThreadedNode pre;  //辅助结点

    public ThreadedBinaryTree() {
    }

    public ThreadedNode getRoot() {
        return root;
    }

    public void setRoot(ThreadedNode root) {
        this.root = root;
    }

    /**
     * @return void
     * @description 将非线索化二叉树转换为线索化二叉树（重载：线索化二叉树的【起点】一般都是根结点）
     * @author Jun Lu
     * @date 2021-08-24 15:50:37
     */
    public void ThreadedTree() {
        this.ThreadedTree(this.root);
    }

    /**
     * @param node 线索化二叉树的起点结点（一般为根结点）
     * @return void
     * @description 中序遍历-构造中序线索二叉树
     * @author Jun Lu
     * @date 2021-08-24 15:51:22
     */
    public void ThreadedTree(ThreadedNode node) {
        if (node == null) {
            return;
        }

        ThreadedTree(node.getLeft());  //递归一左到底（找到具有空结点域的结点）

        //设置当前结点的前驱
        if (node.getLeft() == null) {
            node.setLeft(pre); //pre默认值为null
            if (pre == null) {    /* 区分：第一个前驱为空的结点 */
                node.setPreNum(3);
            } else node.setPreNum(1);
        }

        //设置前驱结点的后继
        if (pre != null && pre.getRight() == null) {  //只有pre为某一个结点，才有资格当做前驱
            pre.setRight(node);
            pre.setSucNum(2);
        }

        //将当前结点设置为下一个结点的前驱
        pre = node;

        ThreadedTree(node.getRight());  //递归一右到底（找到具有空结点域的结点）
    }


    /**
     * @description 遍历中序线索二叉树：二叉树被线索化后，就可以当做一条【链表】进行遍历了
     * @author Jun Lu
     * @date 2022-03-02 21:29:18
     */
    public void midTraverse() {
        ThreadedNode node = this.root;

        while (node != null) {    //相当于整棵树的作用域
            /**
             * 中序
             */
            while (node.getPreNum() == 0) {
                node = node.getLeft();
            }

            System.out.println(node);

            while (node.getSucNum() == 2) {
                node = node.getRight();
                System.out.println(node);
            }

            node = node.getRight();  //线索化之后，树相当于成为了一条链
        }
    }
}
