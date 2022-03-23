package com.lujun61.algorithm.huffman.tree;

public class HuffmanNodeTreeTest {
    public static void main(String[] args) {
        int[] treeArray = {13,7,8,29,6,1};

        HuffmanNodeTree huff = new HuffmanNodeTree();

        huff.createHuffmanTree(treeArray);

        huff.preTraverse();
    }
}
