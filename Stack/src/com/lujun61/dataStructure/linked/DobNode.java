package com.lujun61.dataStructure.linked;

/* 有了后继，才有前驱！！！       *这句话是插入值时规则的伏笔*  */
public class DobNode {
    public int id;
    public String name;
    public double price;

    public DobNode pre;
    public DobNode next;

    public DobNode(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "DobNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
