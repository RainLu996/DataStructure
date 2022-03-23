package com.lujun61.dataStructure.linked;

public class CircleLinkedList {
    //逻辑头结点
    private CircleNode first = null;

    /* 构建一个环形链表 */

    /**
     * 环形链表添加元素
     * @param num 构建由1 ~ num围成的环形链表
     */
    public void addNode(int num) {
        if (num < 1) {
            System.out.println("无法正确构建环形链表！");
            return;
        }

        /* 逻辑尾结点 */
        CircleNode tail = null;
        for (int i = 1; i <= num; i++) {
            CircleNode node = new CircleNode(i);

            /* 第一个结点特殊对待 */
            if (i == 1) {
                //第一个结点既是头，也是尾
                first = node;
                //环形链表首尾相连，但first逻辑上是‘头’，需要使用tail作为‘尾’来区分
                tail = first;
                first.next = tail;
            } else {
                tail.next = node;
                node.next = first;
                tail = node;
            }
        }
    }

    /**
     * 循环遍历环形链表
     */
    public void traverse() {
        if (first == null) {
            System.out.println("该链表为空！");
            return;
        }

        CircleNode temp = first;
        int count = 1;
        do {
            System.out.println("第" + (count++) + "个结点为：" + temp.no);
            temp = temp.next;
        } while (temp != first);
    }

    /**
     * 约瑟夫环 问题
     * @param startNo 报数的起始编号
     * @param roundNo 报数的大小（范围）
     * @param num 环中有多少个成员（元素）
     */
    public void JosephLoop(int startNo, int roundNo, int num) {
        if (startNo < 1 || startNo > num || first == null) {
            System.out.println("初始化数据有误！");
            return;
        }

        /* 定义逻辑上的尾结点 */
        CircleNode tail = first;

        /**
         * 找到原始环中的 ‘尾’
         */
        while (tail.next != first) {
            tail = tail.next;
        }

        /**
         * 找到报数时一开始的 ‘头’和‘尾’ 【方法：自头结点开始，后移 startNo - 1 次】
         */
        for (int i = 1; i <= startNo - 1; i++) {
            first = first.next;
            tail = tail.next;
        }

        /**
         * 将成员出队
         */
        /* 如果只有一个结点，则不用循环，直接输出即可 */
        while (first != tail) {

            /* 将头结点指向【待出队】的元素 */
            for (int i = 1; i <= roundNo - 1; i++) {
                first = first.next;
                tail = tail.next;
            }

            System.out.printf("元素%d出队\n", first.no);

            /* 出队之后重新调整‘头结点’和‘尾结点’ */
            first = first.next;
            tail.next = first;
        }

        System.out.printf("元素%d最后出队\n", first.no);
    }
}





















