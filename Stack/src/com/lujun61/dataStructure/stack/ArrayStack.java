package com.lujun61.dataStructure.stack;

import com.lujun61.dataStructure.runtimeException.StackIsEmptyException;
import com.lujun61.dataStructure.runtimeException.StackIsFullException;

/**ArrayStack实现功能
 * 1、初始栈
 * 2、压栈
 * 3、弹栈
 * 4、判断当前栈是否为空栈
 * 5、判断当前栈是否是满栈
 */

public class ArrayStack {
    public ArrayStack() {}

    //栈的大小
    private int maxSize;

    //使用数组来模拟栈
    private Object[] stack;

    //top表示栈顶所在的位置；默认情况下没有数据时，使用-1；
    private int top = -1;

    //构造方法初始栈，并设置大小
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new Object[maxSize];
    }

    //判断是否已经满栈
    public boolean isFull() {
        return (this.maxSize - 1) == this.top;
    }

    //判断是否为空栈
    public boolean isEmpty() {
        return this.top == -1;
    }

    //压栈
    public void push(Object val) {
        if (this.isFull()) {
            throw new StackIsFullException("此栈已满！");
        }

        this.stack[++this.top] = val;
    }

    //弹栈
    public Object pop() {
        if (this.isEmpty()) {
            throw new StackIsEmptyException("无法对空栈进行此操作！");
        }

        return this.stack[this.top--];
    }

    //查看栈中的所有元素
    public void list() {
        //判断是否为空栈
        if (this.isEmpty()) {
            throw new StackIsEmptyException("无法对空栈进行此操作！");
        }

        for (int i = 0; i < this.stack.length; i++) {
            System.out.printf("stack[%d] = %d\n", i, this.stack[i]);

        }
    }

    //获取栈中元素的长度
    public int length() {
        return this.top + 1;
    }
}
