package com.algorithms;

public class AvlTree<AnyType extends Comparable<? super AnyType>> {

    private AvlNode<AnyType> root;

    public AvlTree() {
        root = null;
    }

    public void insert(AnyType x){
        root = insert(x,root);
    }


    /**
     * @param x 需要插入的数据
     * @param t 插入的子树的根节点
     * @return 新的子树的根节点
     */
    private AvlNode<AnyType> insert(AnyType x,AvlNode<AnyType> t) {
        if (t == null) {
            return new AvlNode<>(x,null,null);
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0){
            t.left = insert(x, t.left);
        }else if (compareResult > 0){
            t.right = insert(x, t.right);
        }
        return balance(t);
    }

    private int height(AvlNode<AnyType> t) {
        return t == null ? -1 : t.height;
    }

    private static final int ALLOWED_IMBALANCE = 1;


    private AvlNode<AnyType> balance(AvlNode<AnyType> t) {
        if (t == null) {
            return t;
        }
        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {
            if (height(t.left.left) >= height(t.left.right)){
                t = rotateWithLeftChild(t);
            }else {

            }
        }

    }

    private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2) {
        AvlNode<AnyType> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left),height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left),k2.height) + 1;
        return k1;
    }

    private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k1) {
        AvlNode<AnyType> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left),height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right),k1.height) + 1;
        return k2;
    }


    private static class AvlNode<AnyType> {

        AnyType element;
        AvlNode<AnyType> left;
        AvlNode<AnyType> right;
        int height;


        public AvlNode(AnyType element) {
            this(element, null, null);
        }

        public AvlNode(AnyType element, AvlNode<AnyType> lt, AvlNode<AnyType> rt) {
            element = element;
            left = lt;
            right = rt;
            height = 0;
        }

    }

}
