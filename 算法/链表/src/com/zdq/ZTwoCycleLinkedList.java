package com.zdq;

//双向循环链表，解决约瑟夫问题
public class ZTwoCycleLinkedList<E> extends ZAbstractList<E> {
    private Node<E> first;
    private Node<E> last;
    private Node<E> current;

    private static  class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;
        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (prev != null) {
                sb.append(prev.element);
            } else{
                sb.append("null");
            }
            sb.append("_").append(element).append("_");
            if (next != null) {
                sb.append(next.element);
            } else{
                sb.append("null");
            }
            return  sb.toString();
        }
    }

    public void reset() {
        current = first;
    }
    //走一步
    public E next() {
        if (current == null) return null;
        current = current.next;
        return current.element;
    }

    public E remove() {
        if (current == null) return null;
        Node<E> next = current.next;
        E element = remove(current);
        if (size == 0){
            current = null;
        } else{
            current = next;
        }
        return element;
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
            last = new Node<>(oldLast,element,first);
            if (oldLast == null) {
            //size = 0;index = 0
                first = last;
                first.next = first;
                first.prev = first;
            } else{
                oldLast.next = last;
                first.prev = last;
            }
        } else{
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev,element,next);
            next.prev = node;
            prev.next = node;
            if (next == first) {
                //添加到0的位置
                first = node;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        return remove(node(index));
    }
//    删除一个节点
    private E remove(Node<E> node) {
        if (size == 1){
            first = null;
            last = null;
        } else{
            Node<E> prev = node.prev;
            Node<E> next = node.next;
            prev.next = next;
            next.prev = prev;
            if (node == first){ //index = 0
                first = next;
            }
            if (node == last){ // index = size - 1
                last.prev = prev;
            }
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
                stringBuilder.append(",");
            }
            stringBuilder.append(node.toString());
            node = node.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
