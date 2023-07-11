package _03DataStructures.impl;

import _03DataStructures.MyArrayList;

public class MyArrayListImpl<T> implements MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 5;

    private int size;
    private int capacity;
    private Object[] internalArray;

    public MyArrayListImpl(int capacity) {
        this.capacity = capacity;
        internalArray = new Object[this.capacity];
    }

    public MyArrayListImpl() {
        this.capacity = DEFAULT_CAPACITY;
        internalArray = new Object[this.capacity];
    }

    @Override
    public void set(int index, T value) {
        this.internalArray[index] = value;
    }

    @Override
    public T get(int index) {
        return (T) this.internalArray[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(T value) {
        if (capacity == size) {
            resize();
        }
        internalArray[size] = value;
        size++;
    }

    @Override
    public void insert(int index, T value) {

        if (capacity == size) {
            resize();
        }

        if (size == index) {
            add(value);
            return;
        }

        shiftUpFromIndex(index);
        internalArray[index] = value;
        size++;
    }

    @Override
    public void delete(int index) {
        if (index != this.size) {
            shiftDownToIndex(index);
        }
        this.internalArray[this.size] = null;
        size--;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i <= this.size; i++) {
            T currentValue = (T) internalArray[i];
            if (currentValue != null && currentValue.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String value = "[";

        for (int i = 0; i < size; i++) {
            value = value + internalArray[i];
            if (i != size - 1) {
                value = value + ", ";
            }
        }
        value = value + "]";
        return value;
    }

    public int getCapacity() {
        return this.capacity;
    }

    private void shiftUpFromIndex(int index) {
        for (int i = this.size; i > index; i--) {
            internalArray[i] = internalArray[i - 1];
        }
    }

    private void shiftDownToIndex(int index) {
        for (int i = index; i < this.size; i++) {
            internalArray[i] = internalArray[i + 1];
        }
    }

    private void resize() {
        int newCapacity = this.capacity * 2;
        Object[] resizedData = new Object[newCapacity];
        for (int i = 0; i < this.size; i++) {
            resizedData[i] = this.internalArray[i];
        }
        this.internalArray = resizedData;
        this.capacity = newCapacity;
    }

}
