package com.lujun61.algorithm.hashtable;

public class HashTest {
    public static void main(String[] args) {
        Student student1 = new Student(1, "lu");
        Student student2 = new Student(2, "li");
        Student student3 = new Student(3, "chen");
        Student student4 = new Student(4, "wu");
        Student student5 = new Student(4, "gao");

        HashTable table = new HashTable(10);
        table.add(student1);
        table.add(student2);
        table.add(student3);
        table.add(student4);
        table.add(student5);

        table.traverse();

        table.getByID(4);
    }
}
