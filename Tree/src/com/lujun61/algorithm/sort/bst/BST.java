package com.lujun61.algorithm.sort.bst;

import com.lujun61.algorithm.sort.Node;
import com.lujun61.algorithm.tree.exception.TreeIsEmptyException;

public class BST {
    protected Node root;

    public BST() {
    }

    public BST(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }


    public void midTraverse() {
        if (this.root != null) {
            this.root.midTraverse();
        } else throw new TreeIsEmptyException("此树为空");
    }

    public Node selectNodeByVal(int val) {
        if (this.root != null) {
            return this.root.selectNodeByVal(val);
        } else throw new TreeIsEmptyException("此树为空");
    }

    public Node selectNodeParentByVal(int val) {
        if (this.root == null) {
            throw new TreeIsEmptyException("此树为空");
        }

        if (this.root.getValue() == val) {
            return root;
        }

        return this.root.selectNodeParentByVal(val);
    }

    public void addNode(Node node) {
        if (this.root == null) {
            this.setRoot(node);
        } else this.root.addNode(node);
    }


    public void deleteNode(int val) {
        if (this.root == null) {
            return;
        }

        // 如果整棵树只有一个根结点，并且根结点就是要删除的结点。直接置空根结点
        if ((this.root.getValue() == val) && (this.root.getLeft() == null && this.root.getRight() == null)) {
            this.root = null;
            return;
        }

        this.root.deleteNode(val);
    }






















}
