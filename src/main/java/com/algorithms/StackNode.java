package com.algorithms;

public class StackNode<T> {
    T data;
    StackNode next;

    public StackNode() {
        this(null,null);
    }

    public StackNode(T data) {
        this.data = data;
        this.next = null;
    }

    public StackNode(T data, StackNode next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}
