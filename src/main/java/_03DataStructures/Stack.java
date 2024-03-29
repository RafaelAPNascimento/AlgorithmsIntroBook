package _03DataStructures;

public interface Stack<E> {

    boolean isEmpty();

    boolean isFull();

    void push(E e);

    E pop();
}
