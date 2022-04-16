package _03DataStructures.impl;

import _03DataStructures.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MapImpl<K, V> implements Map<K, V> {

    private List<Node<K, V>> bucketArray;

    // current capacity
    private int numBuckets;

    // current size of the list
    private int size;

    public MapImpl() {

        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
    }

    private class Node<K, V> {
        K key;
        V value;
        final int hashCode;

        Node<K, V> next;

        Node(K key, V value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }
    }

    private int hashCode(K key) {
        return Objects.hashCode(key);
    }

    private int getBucketIndex(K key) {

        int hashCode = hashCode(key);
        int index = hashCode % numBuckets;

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

        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        Node<K, V> head = bucketArray.get(bucketIndex);

        Node<K, V> prev = null;

        while (head != null) {

            if (head.key.equals(key) && hashCode == head.hashCode)
                break;

            prev = head;
            head = head.next;
        }

        if (head == null)
            return null;

        size--;

        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);

        return head.value;
    }

    @Override
    public V get(K key) {

        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        Node<K, V> head = bucketArray.get(bucketIndex);

        while (head != null) {

            if (head.key.equals(key) && head.hashCode == hashCode)
                return head.value;

            head = head.next;
        }
        // key not found
        return null;
    }

    @Override
    public void add(K key, V value) {

        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        Node<K, V> head = bucketArray.get(bucketIndex);

        while (head != null) {

            if (head.key.equals(key) && head.hashCode == hashCode) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = bucketArray.get(bucketIndex);
        Node<K, V> newNode = new Node<>(key, value, hashCode);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        // if load factor goes beyond the threshold, then double hash table size
        if ((1.0 * size) / numBuckets >= 0.7) {

            List<Node<K, V>> tmp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;

            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);

            for (Node<K, V> headNode : tmp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
}
