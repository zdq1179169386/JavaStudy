package com.zdq;

//单向链表
public class ZLinkedList<E> extends ZAbstractList<E> {
    private Node<E> first;

    private static  class Node<E> {
        E element;
        Node<E> next;
        public Node(E element,Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
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
        if (index == 0){
            first = new Node<>(element,first);
        } else {
            Node<E> prev = node(index-1);
            prev.next = new Node<>(element,prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> old = first;
        if (index == 0){
            first = first.next;
        } else{
            Node<E> prev = node(index-1);
            old = prev.next;
            prev.next = prev.next.next;
        }
        size--;
        return old.element;
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
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return  node;
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
