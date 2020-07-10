package com.zdq;

import javax.swing.*;

//动态数组
public class ArrayList<E> {
    /**
     * 大小
     */
    private int size;
    /**
     * 存放元素
     */
    private  E[] elements;

    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPATICY = 10;
    /**
     * 元素没找到索引
     */
    private static final int ELEMENT_NOT_FOUNF = -1;

    /**
     * 无餐初始化
     */
    public  ArrayList(){
        this(DEFAULT_CAPATICY);
    }

    /**
     * 初始化容量
     * @param capaticy
     */
    public  ArrayList(int capaticy) {
        capaticy = capaticy < DEFAULT_CAPATICY ? DEFAULT_CAPATICY : capaticy;
        elements = (E[]) new Object[capaticy];
    }

    /**
     * 获取size
     * @return
     */
    public int size() {
        return  size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取元素
     * @param index
     * @return
     */
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置元素
     * @param index
     * @param element
     * @return
     */
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 获取索引
     * @param element
     * @return
     */
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) return i;
        }
        return ELEMENT_NOT_FOUNF;
    }

    /**
     * 是否含有
     * @param element
     * @return
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUNF;
    }

    /**
     * 清除
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * 添加
     * @param element
     */
    public void add(E element) {
       add(size,element);
    }

    /**
     * 根据索引，添加
     * @param index
     * @param element
     */
    public void add(int index,E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size; i > index ; i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 删除
     * @param index
     * @return
     */
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index+1; i <= size -1; i++) {
            elements[i - 1] = elements[i];
        }
        elements[size--] = null;
        return old;
    }

    /**
     * 确保容量
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        System.out.print("----------------");
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.print("oldCapacity:" + oldCapacity + ",newCapacity:"+newCapacity);
    }

    /**
     * 索引越界
     * @param index
     */
    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + "，Size：" + size);
    }

    /**
     * 索引检查
     * @param index
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    /**
     * 添加索引检查
     * @param index
     */
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    /**
     * toString
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Size:"+size).append(",[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(elements[i]);
            if (i != size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
