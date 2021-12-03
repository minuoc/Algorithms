package com.algorithms;

/**
 * 顺序 表
 * @param <T>
 */
public class SequenceList<T> implements IList<T>{
    private T[] itemList;
    private int curLen;
    private int maxSize;

    public SequenceList(int maxSize) {
        this.maxSize = maxSize;
        this.curLen = 0;
        this.itemList = (T[]) new Object[maxSize];
    }

    @Override
    public void insert(int index, T t) throws Exception {
        if (curLen == maxSize){
            throw new Exception("数组已满，无法插入!");
        }
        if (index < 0 || index > curLen){
            throw new Exception("非法的插入位置");
        }
        for (int i = curLen; i > index; i--){
            //将index 之后的数据都向后移动一位
            itemList[i] = itemList[i-1];
        }
        itemList[index] = t;
        curLen ++;
    }

    @Override
    public void clear() {
        curLen = 0;
    }

    @Override
    public void remove(int index) throws Exception {
        if (index < 0 || index >curLen){
            throw new IndexOutOfBoundsException("当前索引不存在！");
        }
        //指定位置之后的元素均向前移动一位
        for (int i = index; i < curLen; i++){
            itemList[i] = itemList[i+1];
        }
        curLen --;
    }

    @Override
    public boolean isEmpty() {
        return curLen == 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >curLen){
            throw new IndexOutOfBoundsException("当前索引不存在！");
        }
        return itemList[index];
    }

    @Override
    public int length() {
        return curLen;
    }

    @Override
    public int indexOf(T t) {
        for (int i = 0; i < curLen; i++){
            if (itemList[i] == t){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void display() {
        for (int i = 0; i < curLen; i++) {
            System.out.println(itemList[i]);
        }
    }


}
