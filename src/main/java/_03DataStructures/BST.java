package _03DataStructures;

import java.util.List;

public interface BST<E> {

    int getSize();

    List<E> inOrderWalk();

    boolean contains(E key);

    E minimum();

    E maximum();

    /**
     * Returns the smallest element greater than or equal to key or null if there is no such element
     * @param key
     * @return
     */
    E higher(E key);

    /**
     * Returns the greatest element smaller than or equal to key or null if there is no such element
     * @param key
     * @return
     */
    E lower(E key);

    boolean insert(E key);

    boolean delete(E key);
}
