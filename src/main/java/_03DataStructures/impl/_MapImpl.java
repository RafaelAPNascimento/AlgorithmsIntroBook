package _03DataStructures.impl;

import _03DataStructures.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class _MapImpl<K, V> implements Map<K, V> {

    private List<Node<K, V>> buckets;
    private int mapSize;
    private float threshold;
    private int bucketSize;


    private class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        int hashCode;

        public Node(K key, V value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?, ?> node = (Node<?, ?>) o;

            if (hashCode != node.hashCode) return false;
            if (!key.equals(node.key)) return false;
            return value.equals(node.value);
        }

        @Override
        public int hashCode() {
            return hashCode;
        }
    }

    public _MapImpl() {
        this((float) 0.7, 10);
    }

    public _MapImpl(int initialBucketSize) {
        this((float) 0.7, initialBucketSize);
    }

    public _MapImpl(float threshold) {
        this(threshold, 10);
    }

    public _MapImpl(float threshold, int bucketSize) {
        this.threshold = threshold;
        this.bucketSize = bucketSize;
        buckets = new ArrayList<>(bucketSize);

        for (int i = 0; i < bucketSize; i++)
            buckets.add(i, null);
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

        int hash = getHash(key);
        int bucketIndex = bucketIndex(hash);

        Node<K, V> head = buckets.get(bucketIndex);
        Node<K, V> prev = null;

        while (nonNull(head)) {
            if (head.key.equals(key) && head.hashCode == hash) {
                break;
            }
            prev = head;
            head = head.next;
        }

        if (isNull(head))
            return null;

        if (isNull(prev)) {
            buckets.set(bucketIndex, head.next);
        }
        else {
            prev.next = head.next;
            //buckets.set(bucketIndex, prev);
        }
        mapSize--;

        return head.value;
    }

    @Override
    public V get(K key) {

        int hash = getHash(key);
        int bucketIndex = bucketIndex(hash);

        Node<K, V> head = buckets.get(bucketIndex);

        while (nonNull(head)) {
            if (head.key.equals(key) && head.hashCode == hash)
                return head.value;

            head = head.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {

        int hash = getHash(key);
        int bucketIndex = bucketIndex(hash);

        Node<K, V> head = buckets.get(bucketIndex);
        Node<K, V> prev = null;

        while (nonNull(head)) {
            if (head.key.equals(key) && head.hashCode == hash) {
                head.value = value;
                return;
            }
            prev = head;
            head = head.next;
        }

        Node<K, V> neW = new Node<>(key, value, hash);

        if (isNull(prev)) {
            buckets.set(bucketIndex, neW);
        }
        else {
            prev.next = neW;
        }
        mapSize++;
        checkThreshold();
    }

    private void checkThreshold() {

        if (mapSize / bucketSize >= threshold) {

            List<Node<K, V>> tmp = buckets;
            bucketSize *= 2;
            mapSize = 0;
            buckets = new ArrayList<>(bucketSize);

            for (int i = 0; i < bucketSize; i++)
                buckets.add(i, null);

            for (Node<K, V> current : tmp) {
                while (nonNull(current)) {
                    add(current.key, current.value);
                    current = current.next;
                }
            }
        }
    }

    private int bucketIndex(int hash) {
        int index = hash % bucketSize;
        return index;
    }

    private int getHash(K key) {

        int hash = Objects.hashCode(key);
        hash = (hash < 0) ? hash * -1 : hash;
        return hash;
    }
}
