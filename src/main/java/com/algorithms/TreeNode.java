package com.algorithms;

/**
 * 树节点抽象
 * @param <T>
 */
public class TreeNode<T> {
    //节点的数据
    private T data;

    private TreeNode left;

    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(T data) {
        this(data,null,null);
    }

    public TreeNode(T data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
