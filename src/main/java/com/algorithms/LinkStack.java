package com.algorithms;

/**
 * 链标实现 栈
 * @param <T>
 */
public class LinkStack<T> implements IStack<T>{
    //栈顶元素
    StackNode top;
    int N;

    public LinkStack() {
        top.data = null;
    }

    @Override
    public void push(T t) throws Exception {
        StackNode<T> node = new StackNode<>();
        node.data = t;
        node.next = top; //链入新的节点
        top = node; //修改栈的栈顶指针
    }

    @Override
    public T pop() {
        if (top != null){
            T t = (T) top.data;
            top = top.next;
            return t;
        }
        return null;
    }

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public T top() {
        if (top == null){
            return null;
        }
        return (T) top.data;
    }




}
