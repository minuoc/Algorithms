package com.algorithms;

public interface IList<T> {
    public void insert(int index, T t) throws Exception;

    public void remove(int index) throws Exception;

    public void clear();

    public boolean isEmpty();

    public T get(int index);

    public int length();

    public int indexOf(T t);

    public void display();
}
