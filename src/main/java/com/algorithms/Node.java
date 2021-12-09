package com.algorithms;

/**
 * 单链表 节点
 */
public class Node<T> {
    //数据域
    public T data;
    //指针域
    public Node next;

    public Node() {
        this(null,null);
    }


    public Node(T data) {
        this.data = data;
        next = null;
    }

    public Node(T t, Node next) {
        this.data = t;
        this.next = next;
    }



}
