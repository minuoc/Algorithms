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
        //获取删除位置的前驱节点
        for (preIndex = -1; preIndex < index - 1 && preNode != null; preIndex++){
            preNode = preNode.next;
        }
        if (preIndex > index - 1 || preNode == null){
            throw new IndexOutOfBoundsException("角标越界！");
        }
        preNode.next = preNode.next.next;
    }

    @Override
    public boolean isEmpty() {
        return length() == 0;
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
        Node h = head;
        int i = 0;
        while(h.next != null){
            h = h.next;
            i ++;
        }
        return i;
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
        Node h = head;
        while(h != null){
            System.out.println(h.data);
            h = h.next;
        }
    }

    /**
     * 所有的都逆转
     */
    public void reverse() {
        Node cur = head; //标记头节点
        Node pre = null; //标记前驱节点
        Node temp;
        while(cur != null) {
            // 保存当前节点的下一个节点
            temp = cur.next;

            //cur.next 指向pre 将cur的指针 顺序 反方向
            cur.next = pre;
            //pre cur 继续向后移动
            pre = cur;
            cur = temp;
        }
        //最后一个节点变成新的节点
        head = pre;
    }




    public static void main(String[] args) throws Exception {
        LinkList<Integer> l = new LinkList();
        l.insert(0,1);
        l.insert(1,2);
        l.insert(2,4);
        System.out.println(l.length());
        l.remove(0);
        l.display();


        l.reverse();
        System.out.println("-----------------翻转");
        l.display();

    }
}
