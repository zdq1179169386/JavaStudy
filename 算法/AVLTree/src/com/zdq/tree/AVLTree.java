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
        
    }
}
