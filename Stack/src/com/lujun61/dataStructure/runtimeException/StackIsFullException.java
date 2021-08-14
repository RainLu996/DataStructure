package com.lujun61.dataStructure.runtimeException;

public class StackIsFullException extends RuntimeException{
    public StackIsFullException() {}

    public StackIsFullException(String s) {
        super(s);
    }
}
