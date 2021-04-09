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

    public QueueImpl(Class<E> clazz, int limit) {
        arr = (E[]) Array.newInstance(clazz, limit);
        tail = 0;
        head = 0;
    }

    @Override
    public void enqueue(E e) {
        arr[tail] = e;
        if (tail == arr.length - 1)
            tail = 0;
        else
            tail++;
    }

    @Override
    public E dequeue() {
        E e = arr[head];
        if (head == arr.length - 1)
            head = 0;
        else
            head++;

        return e;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
}
