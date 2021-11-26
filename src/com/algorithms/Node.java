package com.algorithms;

public class Node<T> {
    public T data;
    public Node next;

    public Node() {
        this(null,null);
    }

    public Node(T t, Node node) {
        data = t;
        next = node;
    }

    public Node(T t) {
        data = t;
        next = null;
    }
}
