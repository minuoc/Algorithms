package com.algorithms;


public class AvlTree<AnyType extends Comparable<? super AnyType>> {

    private AvlNode<AnyType> root;

    public AvlTree() {
        root = null;
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }


    /**
     * @param x 需要插入的数据
     * @param t 插入的子树的根节点
     * @return 新的子树的根节点
     */
    private AvlNode<AnyType> insert(AnyType x, AvlNode<AnyType> t) {
        if (t == null) {
            return new AvlNode<>(x, null, null);
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        }
        return balance(t);
    }


    public boolean isEmpty(){
        return root == null;
    }

    private AnyType findMin() throws Exception {
        if (isEmpty()){
            throw new Exception("空");
        }
        return findMin(root).element;
    }

    private AvlNode<AnyType> findMin(AvlNode<AnyType> t) {
        if (t == null) {
            return t;
        }
        while (t.left != null) {
            t = t.left;
        }
        return t;
    }



    private AnyType findMax() throws Exception {
        if (isEmpty()){
            throw new Exception("空");
        }
        return findMax(root).element;
    }

    private AvlNode<AnyType> findMax(AvlNode<AnyType> t) {
        if (t == null) {
            return t;
        }
        while (t.right != null) {
            t = t.right;
        }
        return t;
    }

    public void remove(AnyType x){
        root = remove(x,root);
    }

    private AvlNode<AnyType> remove(AnyType x,AvlNode<AnyType> t){
        if (t == null) {
            return t;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0){
            t.left = remove(x,t.left);
        }else if (compareResult > 0){
            t.right = remove(x,t.right);
        }else if (t.left != null && t.right != null){
            //两个children
            t.element = findMin(t.right).element;
            t.right = remove(t.element,t.right);
        }else {
            t = (t.left != null) ? t.left : t.right;
        }
        return balance(t);
    }

    public boolean contains(AnyType x){
        return contains(x,root);
    }

    private boolean contains(AnyType x, AvlNode<AnyType> t) {
        while (t != null) {
            int compareResult = x.compareTo(t.element);
            if (compareResult < 0) {
                t = t.left;
            } else if (compareResult > 0) {
                t = t.right;
            } else {
                return true;
            }
        }
        return false;
    }

    private void printTree(){
        printTree(root);
    }
    private void printTree(AvlNode<AnyType> t) {
        if (t != null){
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    private int height(AvlNode<AnyType> t) {
        return t == null ? -1 : t.height;
    }

    private static final int ALLOWED_IMBALANCE = 1;


    private AvlNode<AnyType> balance(AvlNode<AnyType> t) {
        if( t == null ) {
            return t;
        }

        if( height( t.left ) - height( t.right ) > ALLOWED_IMBALANCE ) {
            if( height( t.left.left ) >= height( t.left.right ) ) {
                t = rotateWithLeftChild( t );
            } else {
                t = doubleWithLeftChild( t );
            }
        } else if( height( t.right ) - height( t.left ) > ALLOWED_IMBALANCE ) {
            if( height( t.right.right ) >= height( t.right.left ) ) {
                t = rotateWithRightChild( t );
            } else {
                t = doubleWithRightChild( t );
            }
        }
        t.height = Math.max( height( t.left ), height( t.right ) ) + 1;
        return t;

    }

    public void checkBalance() {
        checkBalance(root);
    }

    private int checkBalance(AvlNode<AnyType> t) {
        if (t == null) {
            return -1;
        }
        if (t != null) {
            int hl = checkBalance(t.left);
            int hr = checkBalance(t.right);
            if (Math.abs(height(t.left) - height(t.right)) > 1 || height(t.left) != hl || height(t.right) != hr) {
                System.out.println("OOPS");
            }

        }
        return height(t);
    }


    private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2) {
        AvlNode<AnyType> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k1) {
        AvlNode<AnyType> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        return k2;
    }

    private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
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
            this.element = element;
            this.left = lt;
            this.right = rt;
            this.height = 0;
        }

    }


    public static void main(String[] args) throws Exception {
        AvlTree<Integer> t = new AvlTree<>();
        final int SMALL = 40;
        final int NUMS = 1000000;
        final int GAP = 37;

        System.out.println( "Checking... (no more output means success)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
        {
            //    System.out.println( "INSERT: " + i );
            t.insert( i );
            if( NUMS < SMALL ) {
                t.checkBalance( );
            }
        }

        for( int i = 1; i < NUMS; i+= 2 )
        {
            //   System.out.println( "REMOVE: " + i );
            t.remove( i );
            if( NUMS < SMALL ) {
                t.checkBalance( );
            }
        }
        if( NUMS < SMALL ) {
            t.printTree( );
        }
        if( t.findMin( ) != 2 || t.findMax( ) != NUMS - 2 ) {
            System.out.println( "FindMin or FindMax error!" );
        }

        for( int i = 2; i < NUMS; i+=2 ) {
            if( !t.contains( i ) ) {
                System.out.println( "Find error1!" );
            }
        }

        for( int i = 1; i < NUMS; i+=2 )
        {
            if( t.contains( i ) ) {
                System.out.println( "Find error2!" );
            }
        }

    }

}
