package com.algorithms;

import java.util.Arrays;

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

    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY){
            throw new IllegalStateException("Attempt to create a bag whose capacity exeeds allowed" +
                    "maximum of " + MAX_CAPACITY);
        }
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

        /**
         * 上面的也可以使用 哨兵 来控制  即在数组的0 的位置 放入new Entry  可以省略 parentIndex > 0 的判断
         */

        //最后将新项放入到正确的位置
        heap[newIndex] = newEntry;
        lastIndex ++;
        // 如果 heap 已满 则 倍数增大数组大小
        ensureCapacity();

    }

    private void ensureCapacity() {
        if (lastIndex >= heap.length - 1) {
            int newCapacity = 2 * (heap.length - 1);
            checkCapacity(newCapacity);
            heap = Arrays.copyOf(heap,newCapacity);
        }

    }

    private void checkInitialization() {
        if (!initialized){
            throw new SecurityException("ArrayQueue object is corrupt");
        }
    }

    @Override
    public T removeMax() {
        checkInitialization();
        T root = null;
        if (!isEmpty()) {
            root = heap[1];
            heap[1] = heap[lastIndex];
            lastIndex --;
            reheap(1);
        }
        return root;
    }

    /**
     *  将半堆转化为 堆
     *  Transforms the semiheap at rootIndex into a heap.
     * @param rootIndex
     */
    private void reheap(int rootIndex) {
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex;
        //！done 且 heap[rootIndex]有一个孩子
        while(!done && (leftChildIndex <= lastIndex)) {
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;
            if (rightChildIndex <= lastIndex
                    && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0){
                largerChildIndex = rightChildIndex;
            }

            if (orphan.compareTo(heap[largerChildIndex]) < 0) {
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            }else {
                done = true;
            }
        }
        heap[rootIndex] = orphan;

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
