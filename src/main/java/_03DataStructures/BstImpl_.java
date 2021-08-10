package _03DataStructures;

public class BstImpl_<K extends Comparable<K>, V> implements BST_<K, V> {

    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int nodeCount;      // nodes in subtree rooted here

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

        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left, key);

        else if (cmp > 0)
            return get(x.right, key);

        else
            return x.value;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node x, K key, V value) {

        if (x == null)
            return new Node(key, value, 1);

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, value);

        else if (cmp > 0)
            x.right = put(x.right, key, value);

        else
            x.value = value;
        x.nodeCount = size(x.left) + size(x.right) + 1;

        return x;
    }

    @Override
    public K min() {
        return null;
    }

    @Override
    public K floor(K key) {
        return null;
    }

    @Override
    public K select(int k) {
        return null;
    }

    @Override
    public int rank(K key) {
        return 0;
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void delete(K key) {

    }

    @Override
    public Iterable<K> keys() {
        return null;
    }

    @Override
    public Iterable<K> keys(K lo, K hi) {
        return null;
    }
}
