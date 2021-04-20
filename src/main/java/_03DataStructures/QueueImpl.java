package _03DataStructures;

import java.lang.reflect.Array;

/**
 * FIFO
 * @param <E>
 */
public class QueueImpl<E> implements Queue<E> {

    private E[] arr;
    private int tail;
    private int head;
    private final int capacity;
    private int counter;

    public QueueImpl(Class<E> clazz, int limit) {
        arr = (E[]) Array.newInstance(clazz, limit);
        capacity = limit;
        tail = 0;
        head = 0;
        counter = 0;
    }

    @Override
    public void enqueue(E e) {
        if (isFull())
            throw new RuntimeException("Queue Overflow");

        arr[tail] = e;
        counter++;
        if (tail == capacity - 1)
            tail = 0;
        else
            tail++;
    }

    @Override
    public E dequeue() {

        if (isEmpty())
            throw new RuntimeException("Queue Underflow");

        E e = arr[head];
        counter--;
        if (head == capacity - 1
        )
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
        return capacity == counter;
    }
}
