package com.lujun61.algorithm.huffman.code;

/**
 * @description 哈夫曼编码的结点类
 * @author Jun Lu
 * @date 2022-03-05 15:42:19
 */
public class HuffmanCodeNode implements Comparable<HuffmanCodeNode> {
    private Byte data;  //用来存储某一个字符
    private int weight;  //结点权值（某字符出现的【次数】）

    private HuffmanCodeNode left;
    private HuffmanCodeNode right;

    public HuffmanCodeNode() {
    }

    public HuffmanCodeNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public HuffmanCodeNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanCodeNode left) {
        this.left = left;
    }

    public HuffmanCodeNode getRight() {
        return right;
    }

    public void setRight(HuffmanCodeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HuffmanCodeNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(HuffmanCodeNode o) {
        return this.weight - o.weight;  //自动升序
    }

    /**
     * @description 前序遍历
     * @author Jun Lu
     * @date 2022-03-05 15:49:01
     */
    public void preTraverse() {
        System.out.println(this);

        if (this.getLeft() != null) {
            this.getLeft().preTraverse();
        }

        if (this.getRight() != null) {
            this.getRight().preTraverse();
        }
    }
}
