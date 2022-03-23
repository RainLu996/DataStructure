package com.lujun61.algorithm.huffman.tree;

/**
 * @description 哈夫曼树的结点类
 * @author Jun Lu
 * @date 2022-03-05 15:42:51
 */
public class HuffmanNode implements Comparable<HuffmanNode>{
    private int value;
    private HuffmanNode left;
    private HuffmanNode right;

    public HuffmanNode() {
    }

    public HuffmanNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.value - o.value;  //升序
    }

    /**
     * 前序遍历
     */
    public void preTraverse() {
        System.out.println(this);

        if (this.left != null) {
            this.left.preTraverse();
        }

        if (this.right != null) {
            this.right.preTraverse();
        }
    }
}
