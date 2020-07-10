package com.zdq;
import java.util.LinkedList;
import java.util.List;

//单端队列，队尾入队，队头出队
public class Queue<E> {
    private List<E> list = new LinkedList<>();
    public int size() {
        return list.size();
    }
    public boolean isEmpty() {
        return list.size() == 0;
    }
    public void enQueue(E element){
        list.add(element);
    }
    public E deQueue() {
        return list.remove(0);
    }
    public E front() {
        return list.get(0);
    }
}
