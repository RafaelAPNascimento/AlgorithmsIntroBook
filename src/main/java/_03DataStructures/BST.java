package _03DataStructures;

public interface BST<K extends Comparable<K>, V>{

    int size();

    V get(K key);

    void put(K key, V value);

    K min();

    K max();

    K floor(K key);

    K ceiling(K key);

    K select(int rank);

    int rank(K key);

    void deleteMin();

    void delete(K key);

    Iterable<K> keys();

    Iterable<K> keys(K lo, K hi);


}
