package _03DataStructures;

import java.util.List;

public interface BST<E> {

    List<E> inOrderWalk();

    boolean contains(E key);

    E minimum();

    E maximum();
}
