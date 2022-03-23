package com.lujun61.dataStructure.linked;

public class CircleLinkedListTest {
    public static final int NUM = 5;

    public static void main(String[] args) {
        CircleLinkedList cl = new CircleLinkedList();

        cl.addNode(5);
        cl.traverse();

        cl.JosephLoop(2, 2, NUM);
    }
}
