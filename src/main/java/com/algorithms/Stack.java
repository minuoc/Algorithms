package com.algorithms;

/**
 *
 */
public class Stack<T> implements IStack<T>{

    final int maxSize = 100;
    T elements[] = (T[]) new Object[maxSize];
    /**
     * 指针 指向栈顶
     */
    int top;

    public Stack() {
        this.top = 0;
    }

    @Override
    public void push(T t) throws Exception {
        if (top == maxSize){
            throw new Exception("stack overflow");
        }else {
            elements[top++] = t;
        }

    }

    @Override
    public T pop() {
        if (top == 0){
            return null;
        }else {
            top --;
            return elements[top];
        }
    }

    @Override
    public void clear() {
        top = 0;
    }

    @Override
    public boolean isEmpty() {
        if (top > 0){
            return false;
        }
        return true;
    }

    @Override
    public T top() {
        if (top == 0){
            return null;
        }else {
            return elements[top - 1];
        }
    }


}
