package _03DataStructures;

import java.lang.reflect.Array;

/**
 * FIFO
 * @param <E>
 */
public class QueueImpl<E> implements Queue<E> {

    private E[] elements;
    private int tail;
    private int head;
    private int counter;

    public QueueImpl(Class<E> clazz, int limit) {

        elements = (E[]) Array.newInstance(clazz, limit);
        tail = 0;
        head = 0;
        counter = 0;
    }

    @Override
    public void enqueue(E e) {
        if (isFull())
            throw new RuntimeException("Queue Overflow");

        elements[tail] = e;
        counter++;
        if (tail + 1 == elements.length)
            tail = 0;
        else
            tail++;
    }

    @Override
    public E dequeue() {

        if (isEmpty())
            throw new RuntimeException("Queue Underflow");

        E e = elements[head];
        counter--;
        if (head + 1 == elements.length)
            head = 0;
        else
            head++;

        return e;
    }

    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    @Override
    public boolean isFull() {
        return elements.length == counter;
    }
}
