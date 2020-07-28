package com.zdq.set;
import com.zdq.set.tree.BinaryTree;
import com.zdq.set.tree.RBTree;
//用红黑树实现set， treeSet 必须具备可比较性
public class TreeSet<E> implements Set<E> {
    private RBTree<E> tree = new RBTree<>();
    @Override
    public int size() {
        return tree.size();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public void clear() {
        tree.clear();
    }

    @Override
    public boolean contains(E element) {
        return tree.contains(element);
    }

    @Override
    public void add(E element) {
        tree.add(element);
    }

    @Override
    public void remove(E element) {
        tree.remove(element);
    }

    @Override
    public void traversal(Visitor<E> visitor) {
        tree.inorder(new BinaryTree.Visitor<E>() {
            @Override
            public void visit(E element) {
                visitor.visit(element);
            }
        });
    }
}
