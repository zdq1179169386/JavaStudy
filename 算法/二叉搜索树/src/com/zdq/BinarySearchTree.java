package com.zdq;
import com.zdq.printer.BinaryTreeInfo;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

//二叉搜索树
public class BinarySearchTree<E> implements BinaryTreeInfo {
    private int size;
    private Node<E> root;
    private Comparator<E> comparator;//比较器
    //节点类
    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element,Node<E> parent){
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }
        public  boolean hasTwoChilren() {
            return left != null && right != null;
        }
    }
    //    访问者
    public static abstract class Visitor<E> {
        boolean stop;//是否结束
        abstract boolean visitor(E element);//暴露给外界的访问方法
    }

    public BinarySearchTree() {
        //默认比较器是空
        this.comparator = null;
    }

    public BinarySearchTree(Comparator comparator) {
        this.comparator = comparator;
    }

    public void add(E element) {
        elementNotNull(element);
        if (root == null){
            root = new Node<>(element,null);
            size++;
            return;
        }
        Node<E> node = root;
        Node<E> parent = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element,node.element);
            parent = node;
            if (cmp > 0) {
                //大于
                node = node.right;
            } else if (cmp < 0){
                //小于
                node = node.left;
            } else {
                //相等
                node.element = element;
            }
        }
        Node<E> newNode = new Node<>(element,parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else{
            parent.left = newNode;
        }
        size++;
    }

    //比较大小
    private int compare(E e1,E e2) {
        if (this.comparator != null) {
            this.comparator.compare(e1,e2);
        }
        return ((Comparable)e1).compareTo(e2);
    }

    private void elementNotNull(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    public void preorderTraversal(Visitor<E> visitor) {
        if (visitor == null) return;
        preorderTraversal(root,visitor);
    }
    //前序遍历
    private void preorderTraversal(Node<E> node,Visitor<E> visitor) {
        if (node == null) return;
        if (visitor.stop) return;;
        visitor.stop = visitor.visitor(node.element);
        preorderTraversal(node.left,visitor);
        preorderTraversal(node.right,visitor);
    }

    //中序遍历
    public void inorderTraversal(Visitor<E> visitor) {
        if (visitor == null) return;
        inorderTraversal(root,visitor);
    }
    private void inorderTraversal(Node<E> node,Visitor<E> visitor) {
        if (node == null || visitor.stop) return;
        inorderTraversal(node.left,visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visitor(node.element);
        inorderTraversal(node.right,visitor);
    }
    //后序遍历
    public void postorderTraversal(Visitor<E> visitor) {
        if (visitor == null) return;
        postorderTraversal(root,visitor);
    }
    private void postorderTraversal(Node<E> node,Visitor<E> visitor) {
        if (node == null || visitor.stop) return;
        postorderTraversal(node.left,visitor);
        postorderTraversal(node.right,visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visitor(node.element);
    }
    //层序遍历
    public void levelOrderTraversal() {
        if (root ==  null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> temp = queue.poll();
            System.out.println(temp.element);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    public void levelOrder(Visitor<E> visitor) {
        if (root ==  null || visitor == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> temp = queue.poll();
            if (visitor.stop) return;
            visitor.stop = visitor.visitor(temp.element);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    public int height() {
        return height(root);
    }
    //    递归
    private int height(Node<E> node) {
        if (node == null) return 0;
        return  1 + Math.max(height(node.left),height(node.right));
    }
    //    迭代
    public int height2() {
        if (root == null) return 0;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        int levelSize = 1;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            levelSize --;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (levelSize == 0) {
                levelSize = queue.size();
                height ++;
            }
        }
        return height;
    }

    public boolean isComplete() {
        if (root == null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if ( leaf && !node.isLeaf()) {
                return false;
            }
            if (node.left != null) {
                queue.offer(node.left);
            } else {
                if (node.right != null) return  false;
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else {
//                node.left = null 或者 node.left != null
//               往后遍历,都是叶子节点
                leaf = true;
            }
        }
        return true;
    }
    //前驱节点
    private Node<E> predecessor(Node<E> node) {
        if (node == null) return  null;
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }
    //    后继节点
    private Node<E> successor(Node<E> node) {
        if (node == null) return  null;
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }

    public void remove(E element) {
        remove(node(element));
    }
    private Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element,node.element);
            if (cmp == 0) return node;
            if (cmp > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }
//    删除节点
    private void remove(Node<E> node) {
        if (node == null) return;
        if (node.hasTwoChilren()) {
            //度为2
            Node<E> s = successor(node);
            node.element = s.element;
            node = s;
        }
        Node<E> replacement = node.left != null ? node.left : node.right;
        if (replacement != null) {
            replacement.parent = node.parent;
            if (node.parent == null) {
                root = replacement;
            } else if(node == node.parent.left) {
                node.parent.left = replacement;
            } else {
                node.parent.right = replacement;
            }
        } else if (node.parent == null) {
            root = null;
        } else {
            if (node == node.parent.right) {
                node.parent.right = null;
            } else {
                node.parent.left = null;
            }
        }
        size--;
    }

    public boolean contains(E element) {
        return node(element) != null;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    //实现打印的接口
    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>)node).element;
    }
}
