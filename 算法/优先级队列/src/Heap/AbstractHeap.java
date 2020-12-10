package Heap;
import java.util.Comparator;

//堆基础父类
public abstract class AbstractHeap<E> implements Heap<E>{
    protected int size;
    protected Comparator<E> comparator;//比较器

    public AbstractHeap(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public AbstractHeap() {
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

    }

    //比较两个元素大小
    protected int compare(E e1,E e2) {
        return comparator != null ? comparator.compare(e1,e2) : ((Comparable)e1).compareTo(e2);
    }
}
