package com.algorithms;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
            System.out.print(node.getData() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    /**
     * 非递归实现 先序遍历
     * @param node
     */
    public void nonRecPreOrder(TreeNode<T> node) throws Exception {
        //创建并初始化堆栈
        LinkStack<TreeNode<T>> nodeStack = new LinkStack<>();
        TreeNode<T> nodeTemp = node; //nodeTemp 作为遍历指针
        while(nodeTemp != null || !nodeStack.isEmpty()){
            if (nodeTemp != null){ // 根指针非空 遍历左子树
                nodeStack.push(nodeTemp); //根指针进栈
                System.out.print(nodeStack.peek().getData() + " "); //根指针退栈  访问根节点
                nodeTemp = nodeTemp.getLeft();  //每次遇到非空节点 先向 左走
            } else {
                nodeTemp = nodeStack.pop();
                if (nodeTemp == null) {
                    break;
                }
                nodeTemp = nodeTemp.getRight();
            }
        }
    }

    /**
     * 递归实现 中序遍历
     * @param node
     */
    public void inOrder(TreeNode<T> node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrder(node.getRight());
        }
    }


    /**
     * 中序遍历 非递归
     * @param node
     * @throws Exception
     */
    public void nonRecInOrder(TreeNode<T> node) throws Exception {

        //创建并初始化堆栈
        LinkStack<TreeNode<T>> nodeStack = new LinkStack<>();
        TreeNode<T> nodeTemp = node; //nodeTemp 作为遍历指针
        while(nodeTemp != null || !nodeStack.isEmpty()){
            if (nodeTemp != null){
                nodeStack.push(nodeTemp);
                nodeTemp = nodeTemp.getLeft(); //先向左子树走
            }else {
                nodeTemp = nodeStack.pop(); //根指针退栈 访问根节点
                if (nodeTemp == null) {
                    break;
                }
                System.out.print(nodeTemp.getData() + " ");
                nodeTemp = nodeTemp.getRight(); //再向右子树走
            }

        }
    }

    /**
     * 递归 后序遍历
     * @param node
     */
    public void postOrder(TreeNode<T> node){
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }

    /**
     * 非递归 后序遍历
     * @param node
     */
    public void nonRecPostOrder(TreeNode<T> node) throws Exception {
        //创建并初始化堆栈
        LinkStack<TreeNode<T>> nodeStack = new LinkStack<>();
        TreeNode<T> nodeTemp = node; //nodeTemp 作为遍历指针
        TreeNode<T> preNode = null; //表示最近依次的访问节点
        while(nodeTemp != null || !nodeStack.isEmpty()){
            while (nodeTemp != null){ //一直向左走，遍历左子树
                nodeStack.push(nodeTemp);
                nodeTemp = nodeTemp.getLeft(); //先向左子树走
            }
            nodeTemp = nodeStack.peek();
            if (nodeTemp == null){
                break;
            }
            if (nodeTemp.getRight() == null || nodeTemp.getRight() == preNode){
                nodeTemp = nodeStack.pop();
                System.out.print(nodeTemp.getData() + " ");
                preNode = nodeTemp;
                //此处很重要 ，将 刚出栈的节点设置为空， 对应于while循环的条件之一，否则陷入死循环
                nodeTemp = null;

            } else {
                nodeTemp = nodeTemp.getRight(); //访问右子树
            }

        }

    }

    /**
     * 层次遍历
     * @param root
     */
    public void levelOrder(TreeNode<T> root) {
        Queue<TreeNode<T>> nodeQueue = new LinkedList<>();
        TreeNode<T> node = null;
        nodeQueue.add(root); //根节点 入队
        while(!nodeQueue.isEmpty()){  // 队列不为空
            node = nodeQueue.peek();
            System.out.print(node.getData() + " ");
            nodeQueue.poll(); //队头元素出队
            if (node.getLeft() != null){  //左字数不空，左子树 入队列
                nodeQueue.add(node.getLeft());
            }
            if (node.getRight() != null){
                nodeQueue.add(node.getRight());
            }

        }


    }

    public static void main(String[] args) throws Exception {
        //将一个数组转化为一颗完全二叉树
        Object[] array = {1,2,3,4,5,6,7,8};
        LinkBinTree bt = new LinkBinTree();
        TreeNode root = bt.buildTree(array);
        System.out.print("树的高度：");
        System.out.println(bt.height(root));
        System.out.print("节点的个数：");
        System.out.println(bt.size(root));
        System.out.println("先序遍历：");
        bt.preOrder(root);
        System.out.println("\n"+"非递归先序遍历：");
        bt.nonRecPreOrder(root);
        System.out.println();


        System.out.println("中序遍历：");
        bt.inOrder(root);
        System.out.println("\n"+"非递归中序遍历：");
        bt.nonRecInOrder(root);
        System.out.println();

        System.out.println("后序遍历：");
        bt.postOrder(root);
        System.out.println("\n"+"非递归后序遍历：");
        bt.nonRecPostOrder(root);
        System.out.println();

        System.out.println("层次遍历：");
        bt.levelOrder(root);


    }


}
