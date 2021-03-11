package _02SortingAndOrderStatistics.heapSort;

import java.util.Arrays;

public class MaxHeapImpl implements MaxHeap{

    private int[] heap;
    private int size;
    private int limit;

    public MaxHeapImpl(int[] arr) {

        if (arr == null)
            throw new NullPointerException("Initial array can't be null");

        this.heap = arr;
        this.size = arr.length;
        limit = size;
    }

    public MaxHeapImpl(int limit) {

        if (limit < 0)
            throw new NullPointerException("Limit can't be less than 0");

        this.heap = new int[limit];
        this.limit = limit;
        size = 0;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        return 2 * i + 1;
        //return (i << 1) + 1;
    }

    public int rightChild(int i) {
        return 2 * i + 2;
        //return (i << 1) + 2;
    }

    public boolean isLeaf(int i) {
        return i >= (size / 2);
    }

    public int getSize() {
        return size;
    }

    public int height() {
        return size / 2;
    }

    private void swap(int i1, int i2) {
        int tmp = heap[i1];
        heap[i1] = heap[i2];
        heap[i2] = tmp;
    }

    public void maxHeapify(int i) {

        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if (left < getSize() && heap[left] > heap[i])
            largest = left;

        if (right < getSize() && heap[right] > heap[largest])
            largest = right;

        if (largest != i) {
            swap(largest, i);
            maxHeapify(largest);
        }
    }

    public void buildMaxHeap() {
        size = heap.length;
        for (int i = getSize() / 2 - 1; i >= 0; i--)
            maxHeapify(i);
    }

    public void heapSort() {

        for (int i = getSize() - 1; i > 0; i--) {
            swap(0, i);
            --size;
            maxHeapify(0);
        }
        size = 0;
    }

    // priority key operations
    public int getMax() {
        if (getSize() > 0)
            return heap[0];
        else
            throw new UnsupportedOperationException("Heap underflow");
    }

    public int extractMax() {

        if (getSize() == 0)
            throw new UnsupportedOperationException("Heap underflow");

        int max = heap[0];
        swap(0, getSize() - 1);
        --size;
        maxHeapify(0);
        return max;
    }

    public void insert(int key) {
        if (getSize() == limit)
            throw new UnsupportedOperationException("Heap overflow");

        heap[getSize()] = key;
        int current = getSize();
        size++;
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int[] getHeap() {
        return Arrays.copyOf(heap, size);
    }


}