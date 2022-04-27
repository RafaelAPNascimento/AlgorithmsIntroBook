package _03DataStructures.impl;

import _03DataStructures.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class MapImpl<K, V> implements Map<K, V> {

    private List<Node<K, V>> bucketArray;

    // current capacity
    private int numBuckets;

    // current size of the list
    private int size;

    private double THRESHOLD = 0.7;

    public MapImpl() {
        this(10);
    }

    public MapImpl(double threshold) {
        this(10);
        THRESHOLD = threshold;
    }

    public MapImpl(int numBuckets, double threshold) {
        this(10);
        THRESHOLD = threshold;
    }

    public MapImpl(int numBuckets) {

        bucketArray = new ArrayList<>();
        this.numBuckets = numBuckets;
        size = 0;

        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
    }

    private class Node<K, V> {
        K key;
        V value;
        final int hashCode;

        // Reference to next node
        Node<K, V> next;

        // Constructor
        public Node(K key, V value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }
    }

    private int getHashCode(K key) {

        return Objects.hashCode(key);
    }

    private int getBucketIndex(K key) {

        int hash = getHashCode(key);
        int index = hash % numBuckets;
        index = index < 0 ? index * -1 : index;
        return index;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public V remove(K key) {

        int hash = getHashCode(key);
        int bIndex = getBucketIndex(key);

        Node<K, V> head = bucketArray.get(bIndex);
        Node<K, V> prev = null;

        while (nonNull(head)) {

            if (head.key.equals(key) && head.hashCode == hash)
                break;

            prev = head;
            head = prev.next;
        }

        if (isNull(head))
            return null;

        if (isNull(prev))
            bucketArray.set(bIndex, head.next);
        else
            prev.next = head.next;

        size--;
        return head.value;
    }

    @Override
    public V get(K key) {

        int hashCode = getHashCode(key);
        int bucketIndex = getBucketIndex(key);

        Node<K, V> head = bucketArray.get(bucketIndex);

        while (nonNull(head)) {

            if (head.key.equals(key) && head.hashCode == hashCode)
                break;

            head = head.next;
        }

        if (nonNull(head))
            return head.value;

        return null;
    }

    @Override
    public void add(K key, V value) {

        int hash = getHashCode(key);
        int bIndex = getBucketIndex(key);

        Node<K, V> head = bucketArray.get(bIndex);
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

        if (nonNull(prev))
            prev.next = neW;
        else
            bucketArray.set(bIndex, neW);

        size++;

        checkThreshould();
    }

    private void checkThreshould() {

        if ((1.0 * size) / numBuckets >= THRESHOLD) {

            List<Node<K, V> > temp = bucketArray;

            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);

            for (Node<K, V> headNode : temp) {

                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
}
