package com.lujun61.dataStructure.linked;

public class DobLinkedListTest {
    public static void main(String[] args) {
        DobLinkedList list = new DobLinkedList();

        DobNode n_1 = new DobNode(1, "huawei", 8999);
        DobNode n_2 = new DobNode(2, "honor", 5000);
        DobNode n_3 = new DobNode(3, "oppo", 5100);
        DobNode n_4 = new DobNode(4, "apple", 10000);
        DobNode n_5 = new DobNode(5, "xiaomi", 5999);

        list.addTail(n_5);


        list.addOrderUp(n_2);
        list.addOrderUp(n_1);
        list.addOrderUp(n_3);
        list.addOrderUp(n_4);

        list.traverse();
        System.out.println("元素总个数：" + list.getLength());

        System.out.println("-----------------------------------");

        list.deleteNode(4);
        list.traverse();
        System.out.println("元素总个数：" + list.getLength());

        System.out.println("-----------------------------------");

        list.updateNode(new DobNode(3, "redmi", 1999));
        list.traverse();
        
        System.out.println("元素总个数：" + list.getLength());
    }
}
