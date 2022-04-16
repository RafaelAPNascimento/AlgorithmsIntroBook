package _03DataStructures;

// https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/
public interface Map<K, V> {

    /**
     * return the size of the HT
     * @return
     */
    int size();

    boolean isEmpty();

    /**
     * removes the key, value par
     * @param key
     * @return
     */
    V remove(K key);

    /**
     * returns the value corresponding to the key if the key is present in HT
     * @param key
     * @return
     */
    V get(K key);

    /**
     * adds new valid key, value, if already present updates the value
     * @param key
     * @param value
     */
    void add(K key, V value);
}
