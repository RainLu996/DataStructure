package com.lujun61;

/**
 * @description
 * 队列是一种特殊的线性表，特殊之处在于它只允许在表的前端（front）进行删除操作，
 * 而在表的后端（rear）进行插入操作，和栈一样，队列是一种操作受限制的线性表。
 * 进行插入操作的端称为队尾，进行删除操作的端称为队头。
 * @author Jun Lu
 * @date 2021-11-24 14:24:58
 */
public class QueueTest {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);

        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.add(4);


        System.out.println(arrayQueue.get());
        System.out.println(arrayQueue.get());
        System.out.println(arrayQueue.get());
        System.out.println(arrayQueue.get());


        arrayQueue.traverse();
    }
}
