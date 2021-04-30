package _03DataStructures;

import java.lang.reflect.Array;

public class _QueueImpl<E> implements Queue<E> {

    private E[] elements;
    private int head;
    private int tail;
    private int counter;

    public _QueueImpl(Class<E> clazz, int limit) {

        elements = (E[]) Array.newInstance(clazz, limit);
        head = 0;
        tail = 0;
        counter = 0;
    }

    @Override
    public void enqueue(E e) {

        if (isFull())
            throw new RuntimeException("Overflow");

        elements[tail] = e;

        if (tail + 1 == elements.length)
            tail = 0;
        else
            tail++;

        counter++;
    }

    @Override
    public E dequeue() {

        if (isEmpty())
            throw new RuntimeException("Underflow");

        E e = elements[head];

        if (head + 1 == elements.length)
            head = 0;
        else
            head++;

        counter--;

        return e;
    }

    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    @Override
    public boolean isFull() {
        return counter == elements.length;
    }
}
