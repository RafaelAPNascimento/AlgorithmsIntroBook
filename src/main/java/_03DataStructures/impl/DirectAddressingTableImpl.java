package _03DataStructures.impl;

import _03DataStructures.DirectAddressingTable;

import java.lang.reflect.Array;

public class DirectAddressingTableImpl<V> implements DirectAddressingTable<V> {

    private V[] elements;
    private final int DEFAULT_CAPACITY = 1001;

    public DirectAddressingTableImpl(Class<V> clazz) {
        elements = (V[]) Array.newInstance(clazz, DEFAULT_CAPACITY);
    }

    @Override
    public void insert(Integer key, V value) {
        elements[key] = value;
    }

    @Override
    public V delete(Integer key) {
        V value = elements[key];
        elements[key] = null;
        return value;
    }

    @Override
    public V get(Integer key) {
        return elements[key];
    }

    public static void main(String[] args) {
        DirectAddressingTable<String> map = new DirectAddressingTableImpl<>(String.class);
        map.insert(5, "A");
        map.insert(1, "B");
        map.insert(4, "C");
        System.out.println(map.get(5));
        System.out.println(map.delete(5));
        System.out.println(map.get(5));
        System.out.println(map.get(4));
    }
}
