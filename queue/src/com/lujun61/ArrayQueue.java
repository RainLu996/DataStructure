package com.lujun61;

public class ArrayQueue {
    private Object[] queue;
    private int maxSize;
    private int front;
    private int rear;

    public ArrayQueue() {
    }

    /**
     * @param maxSize 创建的队列的大小
     * @description 构建一个maxSize大小的队列
     * @author Jun Lu
     * @date 2021-11-24 14:10:49
     */
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new Object[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    /**
     * @return boolean 空返回true……
     * @description
     * @author Jun Lu
     * @date 2021-11-24 14:15:19
     */
    public boolean isEmpty(){
        return this.front == this.rear;
    }

    /**
     * @return boolean 满队返回true……
     * @description
     * @author Jun Lu
     * @date 2021-11-24 14:15:53
     */
    public boolean isFull(){
        return this.rear == this.maxSize - 1;
    }


    /**
     * @param val 添加的元素
     * @return void
     * @description
     * @author Jun Lu
     * @date 2021-11-24 14:16:24
     */
    public void add(Object val){
        if (this.isFull()) throw new RuntimeException("队列已满！");
        queue[++this.rear] = val;
    }

    /**
     * @return java.lang.Object 获取的元素（先进先出）
     * @description
     * @author Jun Lu
     * @date 2021-11-24 14:16:46
     */
    public Object get(){
        if (this.isEmpty()) throw new RuntimeException("队列为空！");
        return queue[++this.front];
    }

    public void delete(){
        if(this.isEmpty()) throw new RuntimeException("队列为空");


    }

    public  void traverse(){
        for (int i = 0; i <= this.rear; i++) {
            System.out.print(queue[i] + " ");
        }
    }
}
