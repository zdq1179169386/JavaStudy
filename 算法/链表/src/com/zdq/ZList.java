package com.zdq;

public interface ZList<E>  {
    static final int ELEMENT_NOT_FOUND = -1;
    public void clear();

    public int size();

    public boolean isEmpty();

    public boolean contains(E element);

    public void add(E element);

    public E get(int index);

    E set(int index,E element);

    void add(int index,E element);

    E remove(int index);

    int indexOf(E element);
}
