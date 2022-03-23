package com.lujun61.algorithm.huffman.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @description
 * @author Jun Lu
 * @date 2022-03-04 15:27:06
 */
public class HuffmanNodeTree {
    private HuffmanNode root;

    public HuffmanNodeTree() {}

    public HuffmanNodeTree(HuffmanNode root) {
        this.root = root;
    }

    public HuffmanNode getRoot() {
        return root;
    }

    public void setRoot(HuffmanNode root) {
        this.root = root;
    }

    /**
     * @return void
     * @description 前序遍历哈夫曼二叉树
     * @author Jun Lu
     * @date 2022-03-04 14:39:05
     */
    public void preTraverse() {
        if (this.root != null) {
            this.root.preTraverse();
        } else System.out.println("此哈夫曼树为空！");
    }

    /**
     * 根据所给数据创建哈夫曼树，并给根结点赋值
     */
    public void createHuffmanTree(int[] arrays) {
        List<HuffmanNode> nodes = new ArrayList<>();

        /**
         * 将数组中的每一个元素都单独构建成一个结点
         */
        for (int i : arrays) {
            nodes.add(new HuffmanNode(i));
        }

        /**
         * 不需要大于0是因为：最后一个结点就是新生成的root结点(newNode)，是可以直接在集合里面使用的
         */
        /**
         * 根据哈夫曼树的构造原理来理解编码思路
         */
        while (nodes.size() > 1) {
            /* HuffmanNode中的排序规则：从小到大 */
            Collections.sort(nodes);

            HuffmanNode leftNode = nodes.get(0);
            HuffmanNode rightNode = nodes.get(1);
            HuffmanNode newNode = new HuffmanNode(leftNode.getValue() + rightNode.getValue());

            newNode.setLeft(leftNode);
            newNode.setRight(rightNode);

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(newNode);
        }

        this.root = nodes.get(0);
    }
}























