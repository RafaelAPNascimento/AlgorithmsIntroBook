package _03DataStructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class BstImpl<E> implements BST<E> {

    private final Class<E> type;
    private int size;
    private Node<E> root;
    private Node<E> tail;
    private Comparator<E> comparator;

    public BstImpl(Class<E> type, Comparator<E> comparator) {
        this.type = type;
        this.comparator = comparator;
    }

    @Override
    public List<E> inOrderWalk() {

        List<E> list = new ArrayList<>(size);
        inOrderWalk(root, list);
        return list;
    }

    private void inOrderWalk(Node<E> node, List<E> list) {

        if (!Objects.isNull(node)) {
            inOrderWalk(node.left, list);
            list.add(node.key);
            inOrderWalk(node.right, list);
        }
    }

    @Override
    public boolean contains(E key) {

        if (key == null)
            return false;

        Node<E> current = root;
        while (current != null && current.key != key)
            if (comparator.compare(current.key, key) == 0)
                return true;
            if (comparator.compare(current.key, key) < 0)
                current = current.right;
            else
                current = current.left;

        return false;
    }

    @Override
    public E minimum() {
        if (root == null)
            throw new RuntimeException("BST is empty");

        Node<E> current = root;
        while (current.left != null)
            current = current.left;

        return current.key;
    }

    @Override
    public E maximum() {
        if (root == null)
            throw new RuntimeException("BST is empty");

        Node<E> current = root;
        while (current.right != null)
            current = current.right;

        return current.key;
    }

    @Override
    public E higher(E key) {
        if (!contains(key))
            throw new RuntimeException("Key does not exist");

        Node<E> current = findNode(key);
        if (current.right != null)
            return current.right.key;
        return null;
    }

    @Override
    public E lower(E key) {
        if (!contains(key))
            throw new RuntimeException("Key does not exist");

        Node<E> current = findNode(key);
        if (current.left != null)
            return current.left.key;
        return null;
    }

    private Node<E> findNode(E key) {
        Node<E> current = root;
        while (current != null && current.key != key)
            if (comparator.compare(current.key, key) < 0)
                current = current.right;
            else
                current = current.left;

        return current;
    }

    @Override
    public boolean insert(E key) {
        Node<E> neW = new Node(key);
        Node<E> current = root;
        Node<E> y = null;
        while (current != null) {
            y = current;
            if (comparator.compare(current.key, key) < 0)
                current = current.right;
            else
                current = current.left;
        }

        neW.parent = y;
        if (comparator.compare(y.key, key) < 0)
            y.right = neW;
        else
            y.left = neW;

        return true;
    }

    @Override
    public boolean delete(E key) {

        return false;
    }

    private void transplant(Node<E> n1, Node<E> n2) {

    }

    private class Node<E> {

        E key;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        Node(E data) {
            this.key = data;
        }
    }
}
