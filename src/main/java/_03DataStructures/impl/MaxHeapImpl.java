package _03DataStructures.impl;

import _03DataStructures.MaxHeap;

import java.util.Arrays;
import java.util.Objects;

public class MaxHeapImpl implements MaxHeap {

    private int[] heap;
    private int heapSize;

    public MaxHeapImpl(int[] heap) {

        Objects.requireNonNull(heap, "Initial heap can not be null");
        this.heap = Arrays.copyOf(heap, heap.length);
        buildMaxHeap();
    }

    public MaxHeapImpl(int capacity) {

        if (capacity <= 0)
            throw new IllegalArgumentException("Limit must be greater than zero");

        heap = new int[capacity];
        heapSize = 0;
    }

    @Override
    public int parent(int i) {
        return (i - 1) / 2;
    }

    @Override
    public int leftChild(int i) {
        return i * 2 + 1;
    }

    @Override
    public int rightChild(int i) {
        return i * 2 + 2;
    }

    @Override
    public boolean isLeaf(int i) {
        return i >= heapSize / 2 - 1;
    }

    @Override
    public int getSize() {
        return heapSize;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public int[] getHeap() {
        return Arrays.copyOf(heap, heapSize);
    }

    @Override
    public void maxHeapify(int i) {

        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < heapSize && heap[left] > heap[largest])
            largest = left;

        if (right < heapSize && heap[right] > heap[largest])
            largest = right;

        if (largest != i) {
            swapp(heap, largest, i);
            maxHeapify(largest);
        }
    }

    @Override
    public void buildMaxHeap() {

        heapSize = heap.length;

        for (int i = heap.length / 2 - 1; i >= 0; i--) {

            maxHeapify(i);
        }
    }

    @Override
    public int[] heapSort() {

        int tmp = heapSize;
        for (int i = heapSize - 1; i > 0; i--) {

            swapp(heap, 0, i);
            --heapSize;
            maxHeapify(0);
        }
        heapSize = 0;
        return Arrays.copyOf(heap, tmp);
    }

    @Override
    public int getMax() {
        return heap[0];
    }

    @Override
    public int extractMax() {

        int max = heap[0];
        swapp(heap, 0, --heapSize);
        maxHeapify(0);
        return max;
    }

    @Override
    public void insert(int key) {

        int current = heapSize++;
        heap[current] = key;

        while (heap[parent(current)] < heap[current]) {

            swapp(heap, current, parent(current));
            current = parent(current);
        }
    }
}
