package _02SortingAndOrderStatistics.heapSort;

public interface MaxHeap {

    int parent(int i);

    int leftChild(int i);

    int rightChild(int i);

    boolean isLeaf(int i);

    int getSize();

    int height();

    int[] getHeap();

    void maxHeapify(int i);

    void buildMaxHeap();

    int[] heapSort();

    int getMax();

    int extractMax();

    void insert(int key);

    default void swapp(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
