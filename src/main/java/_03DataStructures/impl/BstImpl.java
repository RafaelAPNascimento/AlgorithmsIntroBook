package _03DataStructures.impl;

import _03DataStructures.BST;

import java.util.ArrayDeque;
import java.util.Queue;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class BstImpl<K extends Comparable<K>, V> implements BST<K, V> {

    private Node root;

    private class Node {

        private K key;
        private V value;
        private Node left;
        private Node right;
        int nodeCount;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.nodeCount = 1;  // each node has a default size that counts 1 (itself at least)
        }
    }

    @Override
    public int size() {

        return size(root);
    }

    /**
     * Size
     * @param x
     * @return The quantity of nodes smaller than or equal to it
     */
    private int size(Node x) {

        if (x == null)
            return 0;
        else
            return x.nodeCount;
    }

    @Override
    public V get(K key) {

        return get(root, key);
    }

    private V get(Node x, K key) {

        if (x == null)
            return null;

        int cmp = x.key.compareTo(key);

        if (cmp == 0)
            return x.value;

        if (cmp > 0)
            return get(x.left, key);

        else
            return get(x.right, key);
    }

    @Override
    public void put(K key, V value) {

        root = put(root, key, value);
    }

    private Node put(Node x, K key, V value) {

        if (isNull(x))
            return new Node(key, value);

        int cmp = x.key.compareTo(key);

        if (cmp < 0)
            x.right = put(x.right, key, value);

        else if (cmp > 0)
            x.left = put(x.left, key, value);

        else
            x.value = value;

        x.nodeCount = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public K min() {

        Node min = min(root);
        if (min != null)
            return min.key;
        else
            return null;
    }

    private Node min(Node x) {

        if (x == null)
            return null;

        if (x.left != null)
            return min(x.left);

        return x;
    }

    @Override
    public K max() {

        if (root == null)
            return null;

        return max(root).key;
    }

    private Node max(Node x) {

        Node greater = x.right;
        if (greater != null)
            return max(greater);
        else
            return x;
    }

    @Override
    public K floor(K key) {

        Node floor = floor(root, key);
        if (nonNull(floor))
            return floor.key;
        else
            return null;
    }

    // LSTE
    private Node floor(Node x, K key) {

        if (x == null)
            return null;

        int cmp = x.key.compareTo(key);

        if (cmp == 0)
            return x;

        else if (cmp > 0)
            return floor(x.left, key);

        Node t = floor(x.right, key);

        if (t == null)
            return x;
        else
            return t;
    }

    @Override
    public K ceiling(K key) {

        Node ceil = ceiling(root, key);
        if (nonNull(ceil))
            return ceil.key;
        else
            return null;
    }

    //  SLT
    private Node ceiling(Node x, K key) {

        if (x == null)
            return null;

        int cmp = x.key.compareTo(key);

        if (cmp == 0)
            return x;

        else if (cmp < 0)
            return ceiling(x.right, key);

        Node t = ceiling(x.left, key);

        if (t == null)
            return x;
        else
            return t;
    }

    @Override
    public K select(int rank) {

        Node select = select(root, rank);
        if (nonNull(select))
            return select.key;
        else
            return null;
    }

    private Node select(Node x, int rank) {

        if (x == null)
            return null;

        int size = size(x.left);

        if (size == rank)
            return x;

        else if (size > rank)
            return select(x.left, rank);

        else
            return select(x.right, rank - size - 1);
    }

    @Override
    public int rank(K key) {

        return rank(root, key);
    }

    private int rank(Node x, K key) {

        if (x == null)
            return 0;

        int cmp = x.key.compareTo(key);

        if (cmp == 0)
            return size(x.left);

        else if (cmp > 0)
            return rank(x.left, key);

        return size(x.left) + rank(x.right, key) + 1;
    }

    @Override
    public void deleteMin() {

        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {

        if (isNull(x))
            return null;

        if (nonNull(x.left))
            x.left = deleteMin(x.left);
        else
            return x.right;

        x.nodeCount = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public void delete(K key) {

        root = delete(root, key);
    }

    private Node delete(Node x, K key) {

        if (x == null)
            return null;

        int cmp = x.key.compareTo(key);
        if (cmp > 0)
            x.left = delete(x.left, key);
        else if (cmp < 0)
            x.right = delete(x.right, key);
        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            else {
                Node del = x;
                x = min(x.right);
                x.right = deleteMin(del.right);
                x.left = del.left;
            }
        }
        x.nodeCount = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public Iterable<K> keys() {

        return keys(min(), max());
    }

    @Override
    public Iterable<K> keys(K lo, K hi) {

        Queue<K> queue = new ArrayDeque<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<K> queue, K lo, K hi) {
        if (x == null)
            return;

        int cmplo = lo.compareTo(x.key);
        int comphi = hi.compareTo(x.key);
        if (cmplo < 0)
            keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && comphi >= 0)
            queue.add(x.key);
        if (comphi > 0)
            keys(x.right, queue, lo, hi);

    }
}
