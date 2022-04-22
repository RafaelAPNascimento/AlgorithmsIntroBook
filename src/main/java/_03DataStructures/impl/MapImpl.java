package _03DataStructures.impl;

import _03DataStructures.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

        int hashCode = getHashCode(key);
        int index = hashCode % numBuckets;
        // key.hashCode() could be negative.
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

        // Apply hash function to find index for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = getHashCode(key);

        // Get head of chain
        Node<K, V> head = bucketArray.get(bucketIndex);

        // Search for key in its chain
        Node<K, V> prev = null;

        while (nonNull(head)) {
            // If Key found
            if (head.key.equals(key) && hashCode == head.hashCode)
                break;

            // Else keep moving in chain
            prev = head;
            head = head.next;
        }

        // If key was not there
        if (head == null)
            return null;

        // Reduce size
        size--;

        // Remove key
        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);

        return head.value;
    }

    @Override
    public V get(K key) {

        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = getHashCode(key);

        Node<K, V> head = bucketArray.get(bucketIndex);

        // Search key in chain
        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode)
                return head.value;
            head = head.next;
        }

        // If key not found
        return null;
    }

    @Override
    public void add(K key, V value) {

        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = getHashCode(key);
        Node<K, V> head = bucketArray.get(bucketIndex);

        // Check if key is already present
        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert key in chain
        size++;
        head = bucketArray.get(bucketIndex);
        Node<K, V> newNode = new Node<K, V>(key, value, hashCode);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        // If load factor goes beyond threshold, then
        // double hash table size
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
