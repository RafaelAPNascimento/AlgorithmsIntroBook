package _03DataStructures;

import java.lang.reflect.Array;

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
        arr[++top] = e;
    }

    @Override
    public E pop() {
        return arr[top--];
    }
}
