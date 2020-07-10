package com.zdq;

import com.zdq.printer.BinaryTreeInfo;

import java.util.*;

//二叉搜索树
public class BinarySearchTree1<E> implements BinaryTreeInfo {
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
    }
//    访问者
    public static abstract class Visitor<E> {
        boolean stop;//是否结束
        abstract boolean visitor(E element);//暴露给外界的访问方法
    }

    public BinarySearchTree1() {
        //默认比较器是空
        this.comparator = null;
    }

    public BinarySearchTree1(Comparator comparator) {
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

    public List<E> preorderTraversal() {
        return preorderTraversal(root);
    }
    //前序遍历
    private List<E> preorderTraversal(Node<E> node) {
        ArrayList<E> arrayList = new ArrayList<>();
        if (node == null) return  arrayList;
        Stack<Node<E>> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node<E> current = stack.pop();
            if (current != null) {
                arrayList.add(current.element);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return arrayList;
    }

    //中序遍历
    public List<E> inorderTraversal() {
        return inorderTraversal(root);
    }
    private List<E> inorderTraversal(Node<E> node) {
       List<E> list = new ArrayList<>();
       Stack<Node<E>> stack = new Stack<>();
       Node<E> current = root;
       while (current != null || !stack.isEmpty()) {
           while (current != null) {
               stack.push(current);
               current = current.left;
           }
           current = stack.pop();
           list.add(current.element);
           current = current.right;
           System.out.println(current);
       }
       return list;
    }
    //后序遍历
    public List<E> postorderTraversal() {
       return  postorderTraversal(root);
    }
    private List<E> postorderTraversal(Node<E> node) {
        Stack<Node<E>> stack = new Stack<>();
        List<E> list = new ArrayList<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                list.add(0, node.element);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }
        return  list;
    }
    //层序遍历
    public List<List<E>> levelOrderTraversal() {
        List<List<E>>  list = new ArrayList<>();
        List<E> arrayList = new ArrayList<>();
        if (root ==  null) {
            list.add(arrayList);
            return list;
        };
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        int levelSize = 1;
        while (!queue.isEmpty()) {
            Node<E> temp = queue.poll();
            arrayList.add(temp.element);
            levelSize--;
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
            if (levelSize == 0) {
                levelSize = queue.size();
                list.add(arrayList);
                arrayList = new ArrayList<>();
            }
        }
        return list;
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
