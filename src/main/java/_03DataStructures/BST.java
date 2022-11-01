package _03DataStructures;

public interface BST<K extends Comparable<K>, V>{

    int size();

    V get(K key);

    void put(K key, V value);

    K min();

    K max();

    /**
     * Finds the largest key smaller than key.
     * @param key
     * @return largest key smaller than key or null.
     */
    K floor(K key);

    /**
     * Finds the smallest key larger than key.
     * @param key
     * @return smallest key larger than key or null
     */
    K ceiling(K key);

    K select(int rank);

    int rank(K key);

    void deleteMin();

    void delete(K key);

    Iterable<K> keys();

    Iterable<K> keys(K lo, K hi);


}
