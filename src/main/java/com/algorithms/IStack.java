package com.algorithms;

public interface IStack<T> {
    public void push(T t) throws Exception;
    public T pop();
    public void clear();
    public boolean isEmpty();
    public T top();
}
