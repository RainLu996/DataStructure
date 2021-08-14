package com.lujun61.dataStructure.runtimeException;

public class StackIsEmptyException extends RuntimeException{
    public StackIsEmptyException() {}

    public StackIsEmptyException(String s) {
        super(s);
    }
}
