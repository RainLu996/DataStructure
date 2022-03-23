package com.lujun61.algorithm.tree;

import com.lujun61.algorithm.tree.exception.DoNotMatchingException;
import com.lujun61.algorithm.tree.exception.TreeIsEmptyException;

/**
 * @description 二叉树类
 * @author Jun Lu
 * @date 2021-08-20 21:01:11
 */
public class BinaryTree {
    private Node root;

    public BinaryTree() {
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    /* 还在这里面定义遍历输出的方法，实际上就是为了简化调用时的操作步骤。《封装》
    * 不需要去new对象，然后再去：对象.getRoot().preTraverse();
    */
    /**
     * @return void
     * @description 前序遍历输出整棵树
     * @author Jun Lu
     * @date 2021-08-20 19:32:43
     */
    public void preTraverse() {
        if (this.root != null) {
            this.root.preTraverse();
        } else {
            throw new TreeIsEmptyException("此树为空！");
        }
    }

    /**
     * @return void
     * @description 中序遍历输出整棵树
     * @author Jun Lu
     * @date 2021-08-20 19:33:15
     */
    public void midTraverse() {
        if (this.root != null) {
            this.root.midTraverse();
        } else {
            throw new TreeIsEmptyException("此树为空！");
        }
    }

    /**
     * @return void
     * @description 后序遍历输出整棵树
     * @author Jun Lu
     * @date 2021-08-20 19:33:32
     */
    public void postTraverse() {
        if (this.root != null) {
            this.root.postTraverse();
        } else {
            throw new TreeIsEmptyException("此树为空！");
        }
    }

    public Node preSearchNodeById(int id) {
        if (this.root != null) {
            return this.root.preSearchNodeById(id);
        } else {
            throw new DoNotMatchingException("未找到目标元素！");
        }
    }

    public Node midSearchNodeById(int id) {
        if (this.root != null) {
            return this.root.midSearchNodeById(id);
        } else {
            throw new DoNotMatchingException("未找到目标元素！");
        }
    }

    public Node postSearchNodeById(int id) {
        if (this.root != null) {
            return this.root.postSearchNodeById(id);
        } else {
            throw new DoNotMatchingException("未找到目标元素！");
        }
    }

    public void deleteNode(int id) {
        if (this.root != null) {
            if (this.root.getNo() == id) {
                this.root = null;
            } else {
                this.root.deleteNode(id);
            }
        } else {
            throw new TreeIsEmptyException("二叉树为空，无法进行删除！");
        }
    }
}