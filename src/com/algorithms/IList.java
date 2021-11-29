package com.algorithms;

/**
 * 线性表
 */
public interface IList<T> {
    public void insert(int index,T t) throws Exception;
    public void clear();
    public void remove(int index) throws Exception;
    public boolean isEmpty();
    public T get(int index);
    public int length();
    public int indexOf(T t);
    //输出线性表中的所有元素
    public void display();
}
