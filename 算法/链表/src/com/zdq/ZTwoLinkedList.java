package com.zdq;

//双向链表
public class ZTwoLinkedList<E> extends ZAbstractList<E> {
    private Node<E> first;
    private Node<E> last;

    private static  class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;
        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == size) {
            //添加到最后的位置
            Node<E> oldLast = last;
            last = new Node<>(oldLast,element,null);
            if (oldLast == null) {
            //size = 0;index = 0
                first = last;
            } else{
                oldLast.next = last;
            }

        } else{
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev,element,next);
            next.prev = node;

            if (prev == null) {
                //添加到0的位置
                first = node;
            } else{
                //添加到中间的位置
                prev.next = node;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null) {
            first = next;
        } else
        {
            prev.next = next;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null){
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else{
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    private Node<E> node(int index) {
        rangeCheck(index);
        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return  node;
        } else{
            Node<E> node = last;
            for (int i = size -1; i > index; i--) {
                node = node.prev;
            }
            return  node;
        }

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size:").append(size).append(",[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0){
                stringBuilder.append("->");
            }
            stringBuilder.append(node.element);
            node = node.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}
