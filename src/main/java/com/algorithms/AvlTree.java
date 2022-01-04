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

    private AvlNode<AnyType> balance(AvlNode<AnyType> t) {
        if (t == null) {
            return t;
        }
        if (height(t.left) - height(t.right) )

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
