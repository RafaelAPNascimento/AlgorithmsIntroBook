package _03DataStructures;

import java.lang.reflect.Array;

/**
 * LIFO
 * @param <E>
 */
public class StackImpl<E> implements Stack<E> {

    private E[] arr;
    private int top;

    public StackImpl(Class<E> clazz, int limit) {
        this.arr = (E[]) Array.newInstance(clazz, limit);
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(E e) {

        if (top + 1 == arr.length)
            throw new IndexOutOfBoundsException("Stack overflow");

        arr[++top] = e;
    }

    @Override
    public E pop() {

        if (top < 0)
            throw new RuntimeException("Stack underflow");

        return arr[top--];
    }
}
