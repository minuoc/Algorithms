package com.algorithms;

/**
 * 顺序存储  循环队列
 */
public class Queue<T> {
    private T[] dataList;
    /**
     * 队列头指针
     */
    private int front;
    /**
     * 队列尾指针
     */
    private int rear;
    /**
     * 队列大小
     */
    private int maxSize;

    public Queue(int maxSize) {
        this.front = 0;
        this.rear = 0;
        this.dataList = (T[]) new Object[maxSize];
    }

    public void add(T t) throws Exception {
        if ((this.rear + 1) % this.dataList.length == this.front) {
            throw new Exception("队列满");
        }
        //front 和 rear 指针的移动采用 加1取余法  体现了顺序存储的 循环使用
        // rear的移动要限制在[0,queueElem.length]之间，用求余来限定它的循环
        this.rear = (this.rear + 1) % this.dataList.length;
        this.dataList[this.rear] = t;
    }

    public T delete() throws Exception {
        if (this.front == this.rear) {
            throw new Exception("队列空");
        } else {
            this.front = (this.front + 1) % this.dataList.length;
            return this.dataList[this.front];
        }
    }

    public void clear() {
        this.front = 0;
        this.rear = 0;
    }

    public boolean isEmpty() {
        return this.front == this.rear;
    }

    public boolean isFull() {
        return this.front == (this.rear + 1) % this.dataList.length;
    }

    public int length() {
        if (!isEmpty()) {
            /**
             * 求长度：这里使用到了求余方式，是考虑到循环队列可能存在队尾指针下标比队首指针下标小的情况
             */
            return (this.rear - this.front + this.dataList.length) % this.dataList.length;
        }
        return this.rear;
    }

    public void display() {
        int i = this.front;
        if (!isEmpty()) {
            while (i != this.rear || this.rear == this.front) {
                i = (i + 1) % this.dataList.length;
                System.out.print(this.dataList[i].toString() + " ");
                if (i == this.rear) {
                    break;
                }
            }
        } else {
            System.out.println("队列为空");
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(5);
        try {
            queue.add(1);
            queue.add(2);
            queue.add(3);
            queue.add(4);
            queue.delete();
            queue.add(5);
            queue.delete();
            queue.add(77);
            queue.display();
            System.out.println();
            System.out.println(queue.isFull());
            System.out.println(queue.isEmpty());
            System.out.println(queue.length());

            System.out.println(queue.delete());
            System.out.println(queue.delete());
            System.out.println(queue.delete());
            System.out.println(queue.delete());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


}
