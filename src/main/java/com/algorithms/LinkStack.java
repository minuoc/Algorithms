package com.algorithms;


/**
 * 链表 实现栈
 * @param <T>
 */
public class LinkStack<T> implements IStack<T>{
    //栈顶元素
    StackNode<T> top;
    //栈内元素的个数
    int N;

    public LinkStack() {
        top = new StackNode();
        N = 0;
    }

    @Override
    public void push(T t) throws Exception {
//         StackNode<T> newNode = new StackNode<>(t,top);
//         top = newNode;

//         StackNode<T> newNode = new StackNode<>();
//         newNode.setNext(top);
//         newNode.setData(t);
//         top = newNode;
//         N++;

        StackNode<T> temp = top;  //修改栈的栈顶指针
        top = new StackNode();
        top.setData(t);
        top.setNext(temp);  //链入新的节点
        N ++;

    }

    @Override
    public T pop() throws Exception {
       T temp = peek();
       assert top != null;
       top = top.getNext();
       return temp;
    }

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public T top() {
        if (top == null){
            return null;
        }
        return (T) top.data;
    }

    //获取栈顶 元素
    public T peek() throws Exception {
        if (isEmpty()){
            throw new Exception("栈为空");
        }
        return top.getData();
    }

    public static void main(String[] args) throws Exception {
        LinkStack<Integer> stack = new LinkStack<>();
        stack.push(1);
        stack.push(2);
        int i = stack.pop();
        System.out.println(i);
        int j = stack.pop();
        System.out.println(j);

    }



}
