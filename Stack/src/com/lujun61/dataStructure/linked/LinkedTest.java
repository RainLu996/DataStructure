package com.lujun61.dataStructure.linked;

public class LinkedTest {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node n_1 = new Node(1, "华为", 7230);
        Node n_2 = new Node(2, "小米", 5999);
        Node n_3 = new Node(3, "苹果", 10000);
        Node n_4 = new Node(4, "one plus", 6000);


        list.tailInsert(new Node(5, "荣耀", 5789));

        list.upForIdInsert(n_2);
        list.upForIdInsert(n_3);
        list.upForIdInsert(n_4);
        list.upForIdInsert(n_1);

        list.traverse();

        System.out.println("--------------------------------------------");

        list.deleteNode(4);
        list.traverse();

        System.out.println("--------------------------------------------");

        list.updateList(new Node(3, "oppo", 5500));
        list.traverse();
        System.out.println(list.getListLength());

    }
}
