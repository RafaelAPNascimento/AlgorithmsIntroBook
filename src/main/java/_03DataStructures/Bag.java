package _03DataStructures;

public interface Bag<E> extends Iterable<E> {

    void add(E element);

    boolean isEmpty();

    int size();
}
