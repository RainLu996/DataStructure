package com.lujun61.dataStructure.linked;

public class Node {
    public int id;

    public String name;

    public double price;

    public Node next;

    public Node(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
