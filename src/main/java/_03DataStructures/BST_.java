package _03DataStructures;

public interface BST_<K extends Comparable<K>, V>{

    int size();

    V get(K key);

    void put(K key, V value);

    K min();

    K floor(K key);

    K select(int k);

    int rank(K key);

    void deleteMin();

    void delete(K key);

    Iterable<K> keys();

    Iterable<K> keys(K lo, K hi);


}
