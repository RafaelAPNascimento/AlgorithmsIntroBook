package _03DataStructures;

public interface DirectAddressingTable<V> {

    void insert(Integer key, V value);

    V delete(Integer key);

    V get(Integer key);

}
