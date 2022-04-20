package _03DataStructures.impl;

import _03DataStructures.Queue;

import java.lang.reflect.Array;

public class QueueImpl<E> implements Queue<E> {

    private int head;
    private int counter;
    private E[] elements;

    public QueueImpl(Class<E> clazz, int limit) {
        elements = (E[]) Array.newInstance(clazz, limit);
        counter = 0;
        head = 0;
    }

    @Override
    public void enqueue(E e) {
        if (isFull())
            throw new RuntimeException("Overflows");

        elements[counter++] = e;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new RuntimeException("Underflow");

        E e = elements[head];

        elements[head++] = null;

        counter--;
        if (head == elements.length)
            head = 0;

        return e;
    }

    @Override
    public boolean isEmpty() {
        return (counter == 0);
    }

    @Override
    public boolean isFull() {
        return counter == elements.length;
    }
}
