package com.algorithms;

/**
 * 单链表
 */
public class LinkList<T> implements IList<T>{
    //头节点
    public Node head;

    public LinkList() {
        head = new Node();
    }



    @Override
    public void insert(int index, T t) throws Exception {
        Node preNode = head;
        int preIndex;
        //查找所插入位置的前驱节点
        for (preIndex = -1;preIndex < index - 1 && preNode != null; preIndex ++){
            preNode = preNode.next;
        }
        if(preIndex > index - 1 || preNode == null){
            throw new Exception("非法操作!");
        }
        //创建新插入的节点对象
        Node newNode = new Node(t);
        newNode.next = preNode.next;
        preNode.next = newNode;

    }

    @Override
    public void clear() {
        head.data = null;
        head.next = null;
    }

    @Override
    public void remove(int index) throws Exception {
        Node preNode = head;
        int preIndex;
        for (preIndex = -1; preIndex < index - 1 && preNode != null; preIndex++){
            preNode = preNode.next;
        }
        if (preIndex > index - 1 || preNode == null){
            throw new IndexOutOfBoundsException("角标越界！");
        }


    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T get(int index) {
        Node nextNode = head.next;
        int j = 0;
        while(j < index && nextNode != null){
            nextNode = nextNode.next;
            j++;
        }
        if (j > index || nextNode == null){
            throw new IndexOutOfBoundsException("元素不存在!");
        }
        return (T) nextNode.data;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public int indexOf(T t) {
        Node nextNode = head.next;
        int index;
        for (index = 0; nextNode != null; index ++){
            if (nextNode.data.equals(t)){
                return index;
            }
        }
        return -1;
    }

    @Override
    public void display() {

    }
}
