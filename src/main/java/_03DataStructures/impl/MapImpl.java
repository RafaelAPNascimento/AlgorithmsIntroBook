package _03DataStructures.impl;

import _03DataStructures.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class MapImpl<K, V> implements Map<K, V> {

    private final float THRESHOLD;

    private List<Node<K, V>> bucketArray;
    private int bucketSize;
    private int mapSize;

    private class Node<K, V> {
        Node<K, V> next;
        private V value;
        private K key;
        private int hash;

        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?, ?> node = (Node<?, ?>) o;

            if (hash != node.hash) return false;
            if (!value.equals(node.value)) return false;
            return key.equals(node.key);
        }

        @Override
        public int hashCode() {
            return hash;
        }
    }

    public MapImpl() {
        this(10);
    }

    public MapImpl(float threshold) {
        this(threshold, 10);
    }

    public MapImpl(float threshold, int initialBucketSize) {
        
        this.THRESHOLD = threshold;
        bucketArray = new ArrayList<>(initialBucketSize);
        bucketSize = initialBucketSize;
        mapSize = 0;
        initiBucket();
    }

    @Override
    public int size() {
        return mapSize;
    }

    @Override
    public boolean isEmpty() {
        return mapSize == 0;
    }

    @Override
    public V remove(K key) {

        if (isEmpty())
            return null;

        int hash = findHashCode(key);
        int index = findBucketIndex(key);

        Node<K, V> head = bucketArray.get(index);
        Node<K, V> prev = null;

        while (nonNull(head)) {
            if (head.key.equals(key) && head.hashCode() == hash)
                break;

            prev = head;
            head = head.next;
        }

        if (isNull(head))
            return null;

        if (isNull(prev))
            bucketArray.set(index, head.next);
        else {
            prev.next = head.next;
        }
        mapSize--;
        return head.value;
    }

    @Override
    public V get(K key) {

        if (isEmpty())
            return null;

        int hash = findHashCode(key);
        int index = findBucketIndex(key);

        Node<K, V> head = bucketArray.get(index);

        while (nonNull(head)) {
            if (head.key.equals(key) && head.hashCode() == hash)
                return head.value;

            head = head.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {

        int hash = findHashCode(key);
        int index = findBucketIndex(key);

        Node<K, V> head = bucketArray.get(index);
        Node<K, V> prev = null;

        while (nonNull(head)) {
            if (head.key.equals(key) && head.hashCode() == hash) {
                head.value = value;
                return;
            }
            prev = head;
            head = head.next;
        }

        Node<K, V> neW = new Node<>(hash, key, value);

        if (isNull(prev)) {
            bucketArray.set(index, neW);
        }
        else {
            prev.next = neW;
        }
        mapSize++;
        checkThreshold();
    }

    private void checkThreshold() {

        if (mapSize / bucketSize >= THRESHOLD) {

            List<Node<K, V>> tmp = bucketArray;
            bucketSize *= 2;
            initiBucket();
            mapSize = 0;

            for (Node<K, V> node : tmp) {
                while (nonNull(node)) {
                    add(node.key, node.value);
                    node = node.next;
                }
            }
        }
    }

    private int findHashCode(K key) {
        return Objects.hashCode(key);
    }

    private int findBucketIndex(K key) {

        int hash = findHashCode(key);
        int index = hash % bucketSize;
        index = index < 0 ? index * -1 : index;
        return index;
    }

    @Override
    public boolean containsKey(K key) {

        int hash = findHashCode(key);
        int bucket = findBucketIndex(key);

        Node head = bucketArray.get(bucket);

        while (nonNull(head)) {
            if (head.key.equals(key) && head.hash == hash)
                return true;
        }
        return false;
    }

    private void initiBucket() {
        bucketArray = new ArrayList<>(bucketSize);
        for (int i = 0; i < bucketSize; i++)
            bucketArray.add(null);
    }
}
