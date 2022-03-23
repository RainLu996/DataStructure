package com.lujun61.stack;

public class ArrayStack {
    public int maxSize;
    public int top;
    public Object[] stack;

    public ArrayStack() {}

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new Object[maxSize];
        this.top = -1;
    }

    public void push(Object obj) {
        stack[++top] = obj;
    }

    public Object pop() {
        return stack[top--];
    }
}

class Test01{
    public static void main(String[] args) {
        ArrayStack s = new ArrayStack(3);
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
