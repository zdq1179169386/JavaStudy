package com.zdq.set.tree;
import java.util.Comparator;
//红黑树
public class RBTree<E> extends BBST<E> {
    private static final boolean RED = false;
    private static final boolean BLACK = false;
    //内部节点类
    private static class RBNode<E> extends Node<E> {
        boolean color = RED;
        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }
        @Override
        public String toString() {
            String str = "";
            if (color == RED) {
                str = "R_";
            }
            return str + element.toString();
        }
    }
    /**
     * 构造方法
     */
    public RBTree() {
        this(null);
    }
    public RBTree(Comparator<E> comparator) {
        super(comparator);
    }
    private Node<E> color(Node<E> node,boolean color) {
        if (node == null) return node;
        ((RBNode<E>)node).color = color;
        return node;
    }

    private Node<E> red(Node<E> node) {
        return  color(node,RED);
    }

    private Node<E> black(Node<E> node) {
        return color(node,BLACK);
    }

    private boolean colorOf(Node<E> node) {
        return node == null ? BLACK : ((RBNode<E>)node).color;
    }
    private boolean isRed(Node<E> node) {
        return  colorOf(node) == RED;
    }
    private boolean isBlack(Node<E> node) {
        return  colorOf(node) == BLACK;
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new RBNode<>(element,parent);
    }
    @Override
    protected void afterAdd(Node<E> node) {
        Node<E> parent = node.parent;
        //添加的是根节点，或者上溢到根节点
        if (parent == null) {
            black(node);
            return;
        }
        if (isBlack(parent)) return;
        //叔父节点
        Node<E> uncle = parent.sibling();
        //祖父节点
        Node<E> grand = red(parent.parent);
        if (isRed(uncle)) {//叔父节点是红色，B树节点上溢
            black(parent);
            black(uncle);
            //把祖父节点当成新添加的节点
            afterAdd(grand);
            return;
        }
        //叔父节点不是红色
        if (parent.isLeftChild()) { //L
            if (node.isLeftChild()) { //LL
                black(parent);
            } else { //LR
                black(node);
                rotateLeft(parent);
            }
            rotateRight(grand);
        } else { //R
            if (node.isLeftChild()) { //RL
                black(node);
                rotateRight(parent);
            } else { //RR
                black(parent);
            }
            rotateLeft(grand);
        }
    }

    @Override
    protected void afterRemove(Node<E> node) {
        if (isRed(node)) {
            black(node);
            return;
        }
        Node<E> parent = node.parent;
        if (parent == null) return;
        boolean left = parent.left == null || node.isLeftChild();
        Node<E> sibling = left ? parent.right : parent.left;
        if (left) {//被删除的元素在左边
            if (isRed(sibling)) {//兄弟节点是红色
                black(sibling);
                red(parent);
                rotateLeft(parent);
                sibling = parent.right;
            }
            //兄弟节点必然是黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                boolean parentBlack = isBlack(parent);
                black(parent);
                red(sibling);
                if (parentBlack) {
                    afterRemove(parent);
                }
            } else {
                //兄弟节点至少有一个红色字节点，向兄弟节点借元素
                if (isBlack(sibling.right)) {
                    rotateRight(sibling);
                    sibling = parent.right;
                }
                color(sibling,colorOf(parent));
                black(sibling.right);
                black(parent);
                rotateLeft(parent);
            }
        } else {//被删除的元素在右边
            if (isRed(sibling)) {//兄弟节点是红色
                black(sibling);
                red(parent);
                rotateRight(parent);
                sibling = parent.left;
            }
            //兄弟节点必然是黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                boolean parentBlack = isBlack(parent);
                black(parent);
                red(sibling);
                if (parentBlack) {
                    afterRemove(parent);
                }
            } else {
                //兄弟节点至少有一个红色字节点，向兄弟节点借元素
                if (isBlack(sibling.left)) {
                    rotateLeft(sibling);
                    sibling = parent.left;
                }
                color(sibling,colorOf(parent));
                black(sibling.left);
                black(parent);
                rotateRight(parent);
            }

        }
    }
}
