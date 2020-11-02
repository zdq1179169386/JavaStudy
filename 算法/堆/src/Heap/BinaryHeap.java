package Heap;
import java.util.Comparator;
//二叉堆
public class BinaryHeap<E> implements Heap<E> {
    private static final int DEFAULT_CAPACITY = 10;//默认容量
    private int size;
    private E[] elements;
    private Comparator<E> comparator;//比较器

    public BinaryHeap(Comparator<E> comparator) {
        this.comparator = comparator;
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public BinaryHeap() {
        this(null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(E element) {
        elementNotNull(element);
        ensureCapacity(size+1);
        elements[size++] = element;
        siftUp(size-1);
    }

    @Override
    public E get() {
        emptyCheck();
        return null;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E replace(E element) {
        return null;
    }
    //上滤
    private void siftUp(int index) {
        E e = elements[index];
        while (index > 0){
            int pIndex = (index-1) >> 1;
            E p = elements[pIndex];
            if (compare(e,p) <= 0) return;
            //交换
            E tmp = elements[index];
            elements[index] = elements[pIndex];
            elements[pIndex] = tmp;
            //重新赋值index
            index = pIndex;
        }
    }
    //扩容
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        //新容量是旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
    //检查空
    private void emptyCheck() {
        if (size == 0){
            throw new IndexOutOfBoundsException("Heap is empty");
        }
    }
    //检查空
    private void elementNotNull(E element) {
        if (element == null){
            throw new IllegalArgumentException("element must not be null");
        }
    }
    //比较两个元素大小
    private int compare(E e1,E e2) {
        return comparator != null ? comparator.compare(e1,e2) : ((Comparable)e1).compareTo(e2);
    }
}
