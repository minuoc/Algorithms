package com.algorithms;

/**
 * 链式存储的 二叉搜索树
 */
public class LinkBinSearchTree {
    private TreeNode<Integer> root;

    public LinkBinSearchTree() {
        root = null;
    }


    public TreeNode<Integer> buildBST(Integer[] array) {
        if (array.length == 0){
            return null;
        } else {
            root = null;
            for (int i = 0; i < array.length; i ++){
                root = insertNode(root,array[i]);
            }
            return root;
        }

    }

    /**
     * 递归实现
     *
     * 在二叉查找树中插入一个数据域为data的节点，新插入的节点一定是某个叶子节点
     * @param node
     * @param data
     * @return
     */
    private TreeNode<Integer> insertNode(TreeNode<Integer> node, Integer data) {
        if (node == null) {
            node = new TreeNode<>(data,null,null);
        } else {
            if (node.getData() == data) { // 树中存在相同的节点，什么也不错

            } else {
                //根节点大于  要插入的数据，插入到左子树中
                if (node.getData() > data) {
                    node.setLeft(insertNode(node.getLeft(),data));
                } else {
                    node.setRight(insertNode(node.getRight(),data));
                }
            }
        }
        return node;
    }


    /**
     * 查找数据为data的节点，若不存在，返回null
     * @param node
     * @param data
     * @return
     */
    public TreeNode<Integer> searchNode(TreeNode<Integer> node, Integer data) {
        while(node != null && node.getData() != data) {
            if (node.getData() > data) {
                node = node.getLeft();
            }else {
                node = node.getRight();
            }
        }
        return node;
    }

    /**
     * 获取最大值
     * @param node
     * @return
     */
    public TreeNode<Integer>  getMaxData(TreeNode<Integer> node) {
        if (node.getRight() == null){
            return node;
        }else {
            return getMaxData(node.getRight());
        }
    }

    /**
     * 获取最小值
     * @param node
     * @return
     */
    public TreeNode<Integer> getMinData(TreeNode<Integer> node){
        if (node.getLeft() == null) {
            return node;
        }else {
            return getMinData(node.getLeft());
        }
    }

    /**
     * 递归实现
     * @param node
     * @param data
     * @return
     */
    public TreeNode<Integer> recSearchNode(TreeNode<Integer> node,Integer data){
       TreeNode<Integer> result = null;
       if (node != null){
           Integer nodeData = node.getData();
           if (nodeData == data){
               return node;
           }else if (nodeData < data) {
               result = recSearchNode(node.getLeft(),data);
           } else {
               result = recSearchNode(node.getRight(),data);
           }
       }
       return result;
    }


    /**
     * 删除数据域为data的节点
     * 按三种情况处理
     * 1.如果被删除的节点z是叶子节点，直接删除，不会破坏二叉查找树的结构
     * 2.如果被删除的节点 只有一颗左子树 或者 右子树， 则 让z的子树成为z的父节点的子树，代替z的位置
     * 3.如果z有左右两颗子树，
     *   则令 z 的直接后继 或者前驱节点 代替z
     *   然后从二叉查找树中 这个直接后继或者直接前驱，这样就转化为第一或者第二种情况
     *
     *   右子树的最小元素 或者 左子树的最大元素 代替被删除的节点
     *
     * @param node
     * @param data
     * @return
     */

    public TreeNode<Integer> delete(TreeNode<Integer> node,Integer data) {
        if (node == null) {
            throw new RuntimeException("树为空");
        }
        //搜索需要删除的结点
        TreeNode<Integer> delNode = searchNode(node,data);
        TreeNode<Integer> parent = null;
        if (delNode == null){
            throw new RuntimeException("树中不存在要删除的关键字");
        } else {




        }
        return null;

    }




}
