package com.algorithms;


import java.util.LinkedList;
import java.util.List;

/**
 * 使用java 实现 二叉树的二叉链标存储
 */
class LinkBinTree<T> {
    /**
     * 根节点
     */
    private TreeNode<T> root;

    private List<TreeNode> nodeList = null;


    public LinkBinTree() {
        root = new TreeNode();
    }

    public LinkBinTree(T data) {
        root = new TreeNode(data);
    }

    /**
     * 将 一个数组转化为一颗完全二叉树
     *
     * @param array
     * @return
     */
    public TreeNode<T> buildTree(T[] array) {
        nodeList = new LinkedList<>();
        //将数组中元素依次转化为TreeNode节点，存放于链表中
        for (int i = 0; i < array.length; i++) {
            nodeList.add(new TreeNode(array[i]));
        }
        /**
         * 对于前 (array.length / 2 - 1) 个 父节点，按照父节点 与孩子节点的数字关系建立完全二叉树
         * 对于完全二叉树，从上到下 ，从左到右 的舒徐依次编号 0，1，2，3....N
         * 则 i > 0 的节点，其左孩子 为 2*i + 1
         * 右孩子 为 2*i + 2
         */
        for (int j = 0; j < (array.length / 2 - 1); j++) {
            nodeList.get(j).setLeft(nodeList.get(j * 2 + 1));
            nodeList.get(j).setRight(nodeList.get(j * 2 + 2));
        }

        //最后一个父节点： 因为最后一个父节点可能没有右孩子，所以单独处理
        int index = array.length / 2 - 1;
        //左孩子
        nodeList.get(index).setLeft(nodeList.get(index * 2 + 1));
        //右孩子 如果数组长度为奇数 才有 右孩子
        if (array.length % 2 == 1) {
            nodeList.get(index).setRight(nodeList.get(index * 2 + 2));
        }
        //设置根节点
        root = nodeList.get(0);
        return root;
    }

    /**
     * 得到树的高度
     */
    public int height(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        int i = height(node.getLeft());
        int j = height(node.getRight());
        //比较 左右 子树 的 高度
        return i < j ? (j + 1) : (i + 1);
    }

    /**
     * 得到节点的个数
     * @param node
     * @return
     */
    public int size(TreeNode<T> node){
        if (node == null){
            return 0;
        }
        return  1 + size(node.getLeft()) + size(node.getRight());
    }

    /**
     * 递归先序遍历 
     * @param node
     */
    public void preOrder(TreeNode<T> node) {
        if (node != null){
            System.out.println(node.getData() + "");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }


}
