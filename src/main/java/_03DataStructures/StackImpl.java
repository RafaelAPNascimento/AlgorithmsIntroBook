package _03DataStructures;

import java.lang.reflect.Array;
import java.util.Optional;

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

    private boolean isFull() {
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
            throw new RuntimeException("Underflow");

        E element = elements[counter - 1];
        elements[--counter] = null;     // prevents memory leak, by eliminating obsolete references
        return element;
    }
}
