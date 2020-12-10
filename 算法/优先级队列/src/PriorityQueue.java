import Heap.BinaryHeap;

import java.util.Comparator;

//优先级队列
public class PriorityQueue<E> {
    //二叉堆
    private BinaryHeap<E> heap;

    public PriorityQueue(Comparator comparator){
        heap = (BinaryHeap<E>) new BinaryHeap<>(comparator);
    }

    public  PriorityQueue(){
        this(null);
    }

    public int size() {
        return  heap.size();
    }
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    public void clear(){
        heap.clear();
    }
    public void enQueue(E element) {
        heap.add(element);
    }
    public E deQueue() {
        return heap.remove();
    }
    public E front() {
        return heap.get();
    }
}
