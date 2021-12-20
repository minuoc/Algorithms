package com.algorithms;

/**
 * 顺序 结构的 堆
 * @param <T>
 */
public class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T> {

    private T[] heap;
    private int lastIndex;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 25;

    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }

    public MaxHeap(int initialCapacity) {
        if (initialCapacity < DEFAULT_CAPACITY){
            initialCapacity = DEFAULT_CAPACITY;
        }else {
            checkCapacity(initialCapacity);
        }
        T[] tempHeap = (T[]) new Comparable[initialCapacity];
        heap = tempHeap;
        lastIndex = 0;
        initialized = true;
    }

    private void checkCapacity(int initialCapacity) {
    }

    /**
     *
     * @param newEntry
     */
    @Override
    public void add(T newEntry) {
        checkInitialization();
        //下一个可用数组位置的下标
        int newIndex = lastIndex + 1;
        //可用位置的父节点位置的下标
        int parentIndex = newIndex / 2;
        //判断 父节点位置的数据 和 可用位置的数据 大小 如果可用位置的数据比父节点的位置的数据大
        // 将父节位置的数据 放入到 可用位置中
        while((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0){
            heap[newIndex] = heap[parentIndex];
            //更新下标
            newIndex  = parentIndex;
            parentIndex = newIndex / 2;
        }

        //最后将新项放入到正确的位置
        heap[newIndex] = newEntry;
        lastIndex ++;
        // 如果 heap 已满 则 倍数增大数组大小
        ensureCapacity();

    }

    private void checkInitialization() {
    }

    @Override
    public T removeMax() {
        return null;
    }

    @Override
    public T getMax() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void clear() {

    }
}
