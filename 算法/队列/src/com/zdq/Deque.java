package com.zdq;
import java.util.LinkedList;
import java.util.List;

//双端队列，队尾队尾都可以出队入队
public class Deque<E> {
    private List<E> list = new LinkedList<>();
    public int size() {
        return list.size();
    }
    public boolean isEmpty() {
        return list.size() == 0;
    }
    public void enQueueRear(E element){
        list.add(element);
    }
    public E deQueueFront() {
        return list.remove(0);
    }
    public void enQueueFront(E element) {
        list.add(0,element);
    }
    public E deQueueRear() {
        return list.remove(list.size()-1);
    }
    public E front() {
        return list.get(0);
    }
    public E rear() {
        return list.get(list.size()-1);
    }
}
