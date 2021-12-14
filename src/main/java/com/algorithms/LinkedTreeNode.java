package com.algorithms;

import java.util.List;

public class LinkedTreeNode<T> {
    /**
     * 存储的数据
     */
    private T data;

    /**
     * 父节点下标
     */
    LinkedTreeNode parent;

    /**
     * 孩子节点引用
     */
    private List<LinkedTreeNode> childNodeList;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedTreeNode getParent() {
        return parent;
    }

    public void setParent(LinkedTreeNode parent) {
        this.parent = parent;
    }

    public List<LinkedTreeNode> getChildNodeList() {
        return childNodeList;
    }

    public void setChildNodeList(List<LinkedTreeNode> childNodeList) {
        this.childNodeList = childNodeList;
    }
}
