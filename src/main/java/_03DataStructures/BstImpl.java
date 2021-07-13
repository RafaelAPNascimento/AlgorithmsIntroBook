package _03DataStructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class BstImpl<E> implements BST<E> {

    private final Class<E> type;
    private int size;
    private Node<E> head;
    private Node<E> tail;
    private Comparator<E> comparator;

    public BstImpl(Class<E> type, Comparator<E> comparator) {
        this.type = type;
        this.comparator = comparator;
    }

    @Override
    public List<E> inOrderWalk() {

        List<E> list = new ArrayList<>(size);
        inOrderWalk(head, list);
        return list;
    }

    private void inOrderWalk(Node<E> node, List<E> list) {

        if (!Objects.isNull(node)) {
            inOrderWalk(node.left, list);
            list.add(node.data);
            inOrderWalk(node.right, list);
        }
    }

    @Override
    public boolean contains(E key) {

        if (key == null)
            return false;

        Node<E> current = head;
        while (current != null && current.data != key)
            if (comparator.compare(current.data, key) == 0)
                return true;
            if (comparator.compare(current.data, key) < 0)
                current = current.right;
            else
                current = current.left;

        return false;
    }

    @Override
    public E minimum() {
        if (head == null)
            throw new RuntimeException("BST is empty");

        Node<E> current = head;
        while (current.left != null)
            current = current.left;

        return current.data;
    }

    @Override
    public E maximum() {
        if (head == null)
            throw new RuntimeException("BST is empty");

        Node<E> current = head;
        while (current.right != null)
            current = current.right;

        return current.data;
    }

    private class Node<E> {

        E data;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        Node(E data) {
            this.data = data;
        }
    }
}
