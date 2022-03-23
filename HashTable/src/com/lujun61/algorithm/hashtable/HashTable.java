package com.lujun61.algorithm.hashtable;

import java.util.List;

/**
 * @description 哈希表（采用拉链法解决哈希冲突）
 * @author Jun Lu
 * @date 2021-08-20 16:57:47
 */
public class HashTable {
    private final StudentLinkedList[] studentLinkedLists;

    private final int size;

    public HashTable(int size) {
        this.size = size;
        this.studentLinkedLists = new StudentLinkedList[size];

        for (int i = 0; i < size; i++) {
            studentLinkedLists[i] = new StudentLinkedList();
        }
    }

    /**
     * @param student 传入的Student类型的数据
     * @return int 哈希值
     * @description 自定义哈希函数
     * @author Jun Lu
     * @date 2021-08-19 20:45:25
     */
    public int hashCode(int id) {
        return id % this.size;
    }

    /**
     * @param student 传入的Student类型的数据
     * @return void
     * @description 为“数组链表”添加值
     * @author Jun Lu
     * @date 2021-08-19 20:44:43
     */
    public void add(Student student) {
        int hashVal = hashCode(student.id);

        studentLinkedLists[hashVal].add(student);
    }

    public void traverse() {
        for (int i = 0; i < this.size; i++) {
            studentLinkedLists[i].traverse(i);
        }
    }

    public void getByID(int id) {
        int hashVal = hashCode(id);

        List<Student> students = studentLinkedLists[hashVal].findByID(id);
        for (Student student :
                students) {
            if (student != null) {
                System.out.println("在第<" + (hashVal + 1) +
                        ">条链表中找到了学员；学员信息为--->姓名：" + student.name + "\t编号：" + student.id);
            } else {
                throw new DoNotElementException("链表中无任何元素！");
            }
        }
    }
}