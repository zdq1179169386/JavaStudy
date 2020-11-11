package Heap;
import java.util.Comparator;

//二叉堆
public class BinaryHeap<E> extends AbstractHeap<E> {
    private static final int DEFAULT_CAPACITY = 10;//默认容量
    private E[] elements;//动态数组

    public BinaryHeap(Comparator<E> comparator) {
        super(comparator);
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public BinaryHeap() {
        this(null,null);
    }

    //批量建堆
    public BinaryHeap(E[] elements) {
        this(elements,null);
    }
    public BinaryHeap(E[] elements,Comparator comparator){
        super(comparator);
        if (elements == null || elements.length == 0){
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else{
            //拷贝
            size = elements.length;
            int capacity = elements.length;
            this.elements = (E[]) new Object[capacity];
            for (int i = 0; i < capacity; i++) {
                this.elements[i] = elements[i];
            }
            heapify();
        }
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
        return elements[0];
    }

    @Override
    public E remove() {
        emptyCheck();
        int lastIndex = --size;
        E root = elements[0];
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;
        siftDown(0);
        return root;
    }

    @Override
    public E replace(E element) {
        elementNotNull(element);
        E root = null;
        if (size == 0){
            elements[0] = element;
            size++;
        } else{
            root = elements[0];
            elements[0] = element;
            siftDown(0);
        }
        return root;
    }
    //上滤
    private void siftUp1(int index) {
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
    //优化上滤
    private void siftUp(int index) {
        E e = elements[index];
        while (index > 0){
            int pIndex = (index-1) >> 1;
            E p = elements[pIndex];
            if (compare(e,p) <= 0) break;
            //将父元素存储在index 的位置
            elements[index] = p;
            //重新赋值index
            index = pIndex;
        }
        elements[index] = e;
    }
    //下滤
    private void siftDown(int index) {
        //第一个叶子节点的索引=非叶子节点的个数
        E element = elements[index];
        int half = size >> 1;
        // index < 第一个叶子节点的索引
        while (index < half) {
            //默认是左子节点
            int childIndex = (index << 1) + 1;
            E child = elements[childIndex];
            int rightIndex = childIndex + 1;
            //选出左右子节点中，比较大那个
            if (rightIndex < size && compare(elements[rightIndex],child) > 0) {
                childIndex = rightIndex;
                child = elements[rightIndex];
            }
            if (compare(element,child) >= 0) break;
            elements[index] = child;
            index = childIndex;
        }
        elements[index] = element;
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
    //批量建堆
    private void heapify() {
        //自上而下的上滤
//        for (int i = 1; i < size; i++) {
//            siftUp(i);
//        }
        //自下而上的下滤
        for (int i = ((size >> 1) -1); i >= 0 ; i--) {
            siftDown(i);
        }
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

}
