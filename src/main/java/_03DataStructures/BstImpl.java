package _03DataStructures;

import java.util.ArrayDeque;
import java.util.Queue;

public class BstImpl<K extends Comparable<K>, V> implements BST<K, V> {

    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;
        int nodeCount;
        public Node(K key, V value, int nodeCount) {
            this.key = key;
            this.value = value;
            this.nodeCount = nodeCount;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

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
        // Return value associated with key in the subtree rooted at x;
        // return null if key not present in subtree rooted at x.
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left, key);     // recursive search in the appropriate subtree

        else if (cmp > 0)
            return get(x.right, key);   // recursive search in the appropriate subtree

        else
            return x.value;
    }

    @Override
    public void put(K key, V value) {
        // Search for key. Update value if found; grow table if new.
        root = put(root, key, value);
    }

    private Node put(Node x, K key, V value) {
        // Change key’s value to val if key in subtree rooted at x.
        // Otherwise, add new node to subtree associating key with val.
        if (x == null)
            return new Node(key, value, 1);

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, value);   // if the search key is less than the key at the root, we set the left link to the result

        else if (cmp > 0)
            x.right = put(x.right, key, value);     // therwise, we set the right link to the result of inserting the key into the right subtree

        else
            x.value = value;

        x.nodeCount = size(x.left) + size(x.right) + 1;

        return x;
    }

    @Override
    public K min() {

        return min(root).key;
    }

    private Node min(Node x) {

        if (x.left == null) return x;

        return min(x.left);
    }

    @Override
    public K max() {

        return max(root).key;
    }

    private Node max(Node x) {

        if (x.right == null) return x;

        return max(x.right);
    }

    @Override
    public K floor(K key) {

        Node x = floor(root, key);
        if (x == null)
            return null;

        return x.key;
    }

    private Node floor(Node x, K key) {

        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;

        if (cmp < 0)
            return floor(x.left, key);

        Node t = floor(x.right, key);

        if (t != null)
            return t;
        else
            return x;
    }

    @Override
    public K ceiling(K key) {
        return null;
    }

    @Override
    public K select(int k) {

        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        // Return Node containing key of rank k
        if (x == null)
            return null;
        int t = size(x.left);
        if (t > k)
            return select(x.left, k);
        else if (t < k)
            return select(x.right, k - t - 1);
        else
            return x;
    }

    @Override
    public int rank(K key) {

        return rank(key, root);
    }

    private int rank(K key, Node x) {
        // Return number of keys less than x.key in the subtree rooted at x
        if (x == null)
            return 0;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return rank(key, x.left);
        else if (cmp > 0)
            return 1 + size(x.left) + rank(key, x.right);
        else
            return size(x.left);
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {

        if (x.left == null)
            return x.right;

        x.left = deleteMin(x.left);
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

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
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
