package _03DataStructures.impl;

import _03DataStructures.Stack;

import java.lang.reflect.Array;

public class StackImpl<E> implements Stack<E> {

    private E[] elements;
    private int counter;

    public StackImpl(Class<E> clazz, int limit) {
        elements = (E[]) Array.newInstance(clazz, limit);
        counter = 0;
    }

    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    @Override
    public boolean isFull() {
        return counter == elements.length;
    }

    @Override
    public void push(E e) {
        if (isFull())
            throw new RuntimeException("Overflows");

        elements[counter++] = e;
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new RuntimeException("underflow");

        E e = elements[--counter];
        elements[counter] = null;   // prevents memory leaks by eliminating obsolete references
        return e;
    }
}
