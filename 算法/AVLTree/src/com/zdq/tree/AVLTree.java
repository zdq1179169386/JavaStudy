package com.zdq.tree;
import java.util.Comparator;

//AVtree
public class AVLTree<E> extends BST<E>{
    public AVLTree() {
        this(null);
    }

    public AVLTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        while ((node = node.parent) != null) {
            if (isBalance(node)) {
                //更新高度
                updateHeight(node);
            } else{
                //恢复平衡
                rebalance(node);
                break;
            }
        }
    }
    /**
     * 恢复平衡
     * @param grand
     */
    private void rebalance2(Node<E> grand) {
        Node<E> parent = ((AVLNode<E>)grand).tallerChild();
        Node<E> node = ((AVLNode<E>)parent).tallerChild();
        if (parent.isLeftChild()) { // L
            if (node.isLeftChild()) {// LL
                rotateRight(grand);
            } else { //LR
                rotateLeft(parent);
                rotateRight(grand);
            }
        } else { //R
            if (node.isLeftChild()) {// RL
                rotateRight(parent);
                rotateLeft(grand);
            } else { //RR
                rotateLeft(grand);
            }
        }
    }

    /**
     * 左旋
     * @param grand
     */
    private void rotateLeft(Node<E> grand) {
        Node<E> parent = grand.right;
        Node<E> node = parent.left;
        grand.right = node;
        parent.left = grand;
        afterRotate(grand,parent,node);
    }

    /**
     * 右旋
     * @param grand
     */
    private void rotateRight(Node<E> grand) {
        Node<E> parent = grand.left;
        Node<E> node = parent.right;
        grand.left = node;
        parent.right = grand;
        afterRotate(grand,parent,node);
    }

    /**
     * 恢复平衡2
     * @param grand
     */
    private void rebalance(Node<E> grand) {
        Node<E> parent = ((AVLNode<E>)grand).tallerChild();
        Node<E> node = ((AVLNode<E>)parent).tallerChild();
        if (parent.isLeftChild()) {//L
            if (node.isLeftChild()) { //LL
                rotate(grand,node,node.right,parent,parent.right,grand);
            } else{ //LR
                rotate(grand,parent,node.left,node,node.right,grand);
            }
        } else{ //R
            if (node.isLeftChild()) { //RL
                rotate(grand,grand,node.left,node,node.right,parent);
            } else{ //RR
                rotate(grand,grand,parent.left,parent,node.left,node);
            }
        }
    }

    /**
     * 统一旋转
     */
    private void rotate(
            Node<E> r,//子树根节点
            Node<E> b, Node<E> c,
            Node<E> d,
            Node<E> e, Node<E> f ) {
        //让d 成为子树的根节点
        d.parent = r.parent;
        if (r.isLeftChild()) {
            r.parent.left = d;
        } else if(r.isRightChild()){
            r.parent.right = d;
        } else{
            root = d;
        }
        //b-c
        b.right = c;
        if (c != null) {
            c.parent = b;
        }
        updateHeight(b);
        //e-f
        f.left = e;
        if (e != null) {
            e.parent = f;
        }
        updateHeight(f);
        //b-d-f
        d.left = b;
        d.right = f;
        b.parent = d;
        f.parent = b;
        updateHeight(d);
    }
    /**
     * 更新父节点和高度
     * @param grand
     * @param parent
     * @param child
     */
    private void afterRotate(Node<E> grand,Node<E> parent,Node<E> child) {
        parent.parent = grand.parent;
        if (grand.isLeftChild()) {
            grand.parent.left = parent;
        } else if (grand.isRightChild()) {
            grand.parent.right = parent;
        } else{
            root = parent;
        }
        if (child != null) {
            child.parent = grand;
        }
        grand.parent = parent;
        //更新高度
        updateHeight(grand);
        updateHeight(parent);
    }

    /**
     * 删除节点也会导致失衡
     * @param node
     */
    @Override
    protected void afterRemove(Node<E> node) {
        while ((node = node.parent) != null) {
            if (isBalance(node)) {
                //更新高度
                updateHeight(node);
            } else{
                //恢复平衡
                rebalance(node);
                break;
            }
        }
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new AVLNode<>(element,parent);
    }

    private boolean isBalance(Node<E> node) {
        return Math.abs( ((AVLNode<E>)node).balanceFactor()) <= 1;
    }

    private void updateHeight(Node<E> node) {
        ((AVLNode<E>)node).updateHeight();
    }

    private static class AVLNode<E> extends Node<E> {
        int height = 1;

        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }
        //平衡因子
        public int balanceFactor() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            return leftHeight - rightHeight;
        }

        public void updateHeight() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            height = 1 + Math.max(leftHeight,rightHeight);
        }
        //找出左右子树中比较高的那个节点
        public Node<E> tallerChild() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            if (leftHeight > rightHeight) return left;
            if (leftHeight < rightHeight) return right;
            return isLeftChild() ? left : right;
        }

        @Override
        public String toString() {
            String parentString = "null";
            if (parent != null) {
                parentString = parent.element.toString();
            }
            return element + "_p(" + parentString +")_h(" + height + ")";
        }
    }
}
