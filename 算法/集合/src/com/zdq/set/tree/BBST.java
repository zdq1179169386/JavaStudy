package com.zdq.set.tree;
import java.util.Comparator;
//平衡二叉搜索树
public class BBST<E> extends BST<E> {
    public BBST() {
        this(null);
    }
    public BBST(Comparator comparator) {
        super(comparator);
    }

    /**
     * 左旋
     * @param grand
     */
    protected void rotateLeft(Node<E> grand) {
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
    protected void rotateRight(Node<E> grand) {
        Node<E> parent = grand.left;
        Node<E> node = parent.right;
        grand.left = node;
        parent.right = grand;
        afterRotate(grand,parent,node);
    }

    /**
     * 更新父节点和高度
     * @param grand
     * @param parent
     * @param child
     */
    protected void afterRotate(Node<E> grand,Node<E> parent,Node<E> child) {
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
    }

    /**
     * 统一旋转
     */
    protected void rotate(
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
        //e-f
        f.left = e;
        if (e != null) {
            e.parent = f;
        }
        //b-d-f
        d.left = b;
        d.right = f;
        b.parent = d;
        f.parent = b;
    }
}
