package _02SortingAndOrderStatistics.heapSort;

public interface MaxHeap {

    int parent(int i);

    int leftChild(int i);

    int rightChild(int i);

    boolean isLeaf(int i);

    int getHeapSize();

    int height();

    int[] getHeap();

    void maxHeapify(int i);

    void buildMaxHeap();

    void heapSort();

    int getMax();

    int extractMax();

    void insert(int key);

}
