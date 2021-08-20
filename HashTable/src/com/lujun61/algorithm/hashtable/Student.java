package com.lujun61.algorithm.hashtable;

/**
 * @description Student类型的结点对象
 * @author Jun Lu
 * @date 2021-08-19 19:12:34
 */
public class Student {
    public int id;
    public String name;
    public Student next;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
