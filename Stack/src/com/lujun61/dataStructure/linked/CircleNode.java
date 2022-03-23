package com.lujun61.dataStructure.linked;


/**
 * 单向 环形链表 结点类
 */
public class CircleNode {
    public int no;
    public CircleNode next;

    public CircleNode() {
    }

    public CircleNode(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "CircleNode{" +
                "no=" + no +
                '}';
    }
}
