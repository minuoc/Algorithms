package com.algorithms;

public class BinarySearchTree<T extends Comparable<? super T>> {

    private BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(T t) {
        root = insert(t, root);
    }

    public void remove(T t) {
        root = remove(t, root);
    }

    public void printTree() {
        if (isEmpty()) {
            System.out.println("树为空");
        } else {
            printTree(root);
        }

    }

    public int height(BinaryNode<T> node) {
        if (node == null) {
            return -1;
        } else {
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }


    /**
     * 查找最小值
     *
     * @return
     */
    public T findMin() throws Exception {
        if (isEmpty()) {
            throw new Exception("树为空");
        }
        return findMin(root).element;
    }

    public T findMax() throws Exception {
        if (isEmpty()) {
            throw new Exception("树为空");
        }
        return findMax(root).element;
    }

    public boolean contains(T t) {
        return contains(t, root);
    }


    private BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    private BinaryNode<T> findMax(BinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.right == null) {
            return node;
        }
        return findMax(node.right);
    }

    private boolean contains(T t, BinaryNode<T> node) {
        if (node == null) {
            return false;
        }
        int compareResult = t.compareTo(node.element);
        if (compareResult < 0) {
            return contains(t, node.left);
        } else if (compareResult > 0) {
            return contains(t, node.right);
        } else {
            return true;
        }

    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }


    private void printTree(BinaryNode<T> node) {
        if (node != null) {
            printTree(node.left);
            System.out.println(node.element);
            printTree(node.right);
        }
    }

    /**
     * 插入
     *
     * @param t
     * @param node
     * @return
     */
    private BinaryNode<T> insert(T t, BinaryNode<T> node) {
        if (node == null) {
            return new BinaryNode<>(t, null, null);
        }
        int compareResult = t.compareTo(node.element);
        if (compareResult < 0) {
            node.left = insert(t, node.left);
        } else if (compareResult > 0) {
            node.right = insert(t, node.right);
        } else {

        }
        return node;

    }

    /**
     * 删除 节点
     *
     * @param t    要删除的元素
     * @param node
     * @return
     */
    private BinaryNode<T> remove(T t, BinaryNode<T> node) {
        if (node == null) {
            return node;
        }
        int compareResult = t.compareTo(node.element);
        if (compareResult < 0) {
            node.left = remove(t, node.left);
        } else if (compareResult > 0) {
            node.right = remove(t, node.right);
        } else if (node.left != null && node.right != null) {
            //有两个子树
            node.element = findMin(node.right).element;
            node.right = remove(node.element, node.right);

        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }


    private static class BinaryNode<T> {

        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(T t) {
            this(t, null, null);
        }

        public BinaryNode(T t, BinaryNode<T> lt, BinaryNode<T> rt) {
            element = t;
            left = lt;
            right = rt;
        }
    }


    public static void main(String[] args) throws Exception {




    }
}
