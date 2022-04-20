package _03DataStructures.impl;

import _03DataStructures.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _MapImpl<K, V> implements Map<K, V> {


    private class Node {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void add(K key, V value) {

    }

    private int hashCode(K k) {
        return Objects.hashCode(k);
    }

    private int getBucket(K key) {
        return 0;
    }
}
