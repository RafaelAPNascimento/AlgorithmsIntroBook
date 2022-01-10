package _02SortingAndOrderStatistics.heapSort;

import java.util.Arrays;
import java.util.Objects;

public class MaxHeapImpl implements MaxHeap {

    private int[] heap;
    private int size;

    public MaxHeapImpl(int[] arr) {

        Objects.requireNonNull(arr, "Initial heap is null");
        this.heap = Arrays.copyOf(arr, arr.length);
        buildMaxHeap();
    }

    public MaxHeapImpl(int limit) {

        if (limit <= 0)
            throw new IllegalArgumentException("limit must be greater than 0");

        heap = new int[limit];
    }

    @Override
    public int parent(int i) {
        return (i - 1) / 2;
    }

    @Override
    public int leftChild(int i) {
        return i * 2 + 1;
        //return (i << 1) + 1;
    }

    @Override
    public int rightChild(int i) {
        return i * 2 + 2;
        //return (i << 1) + 2;
    }

    @Override
    public boolean isLeaf(int i) {
        return i >= size / 2;
    }

    @Override
    public int getHeapSize() {
        return size;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public int[] getHeap() {
        return Arrays.copyOf(heap, size);
    }

    @Override
    public void maxHeapify(int i) {

        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] > heap[largest])
            largest = left;

        if (right < size && heap[right] > heap[largest])
            largest = right;

        if (largest != i) {
            swapp(largest, i);
            maxHeapify(largest);
        }
    }

    @Override
    public void buildMaxHeap() {

        size = heap.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    @Override
    public int[] heapSort() {

        for (int i = size - 1; i > 0; i--) {
            swapp(0, i);
            size--;
            maxHeapify(0);
        }
        size = 0;
        return Arrays.copyOf(heap, heap.length);
    }

    @Override
    public int getMax() {
        return heap[0];
    }

    @Override
    public int extractMax() {

        int max = heap[0];
        swapp(0, --size);
        maxHeapify(0);
        return max;
    }

    @Override
    public void insert(int key) {

        int index = size;
        heap[size++] = key;

        while (heap[parent(index)] < heap[index]) {
            swapp(parent(index), index);
            index = parent(index);
        }
    }

    private void swapp(int i1, int i2) {

        int tmp = heap[i1];
        heap[i1] = heap[i2];
        heap[i2] = tmp;
    }
}
