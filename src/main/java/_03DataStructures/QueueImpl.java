package _03DataStructures;

import java.lang.reflect.Array;

public class QueueImpl<E> implements Queue<E> {

    private E[] arr;

    public QueueImpl(Class<E> clazz, int limit) {
        arr = (E[]) Array.newInstance(clazz, limit);
    }

    @Override
    public void enqueue(E e) {

    }

    @Override
    public E dequeue() {
        return null;
    }
}
