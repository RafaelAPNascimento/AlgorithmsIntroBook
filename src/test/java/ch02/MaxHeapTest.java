package ch02;

import _02SortingAndOrderStatistics.heapSort.MaxHeap;
import _02SortingAndOrderStatistics.heapSort.MaxHeapImpl;
import ch01.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MaxHeapTest {

    @Test
    @DisplayName("Should set max heap property in the whole array")
    public void shouldBuildMaxHeapArray() {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 0};
        MaxHeap maxHeap = new MaxHeapImpl(arr);
        assertTrue(isHeap(maxHeap.getHeap()));
    }

    @Test
    @DisplayName("Should keep max heap property after insert")
    public void shouldKeepMaxHeapPropertyAfterInsert() {

        MaxHeap maxHeap = new MaxHeapImpl(11);
        maxHeap.insert(1);
        maxHeap.insert(4);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(9);
        maxHeap.insert(7);
        maxHeap.insert(99);
        maxHeap.insert(8);
        maxHeap.insert(10);
        maxHeap.insert(14);
        maxHeap.insert(16);
        assertTrue(isHeap(maxHeap.getHeap()));
    }

    @Test
    public void shouldReturnHeapSizeCorrectly() {

        MaxHeap maxHeap = new MaxHeapImpl(6);
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        assertEquals(3, maxHeap.getHeapSize());
    }

    @Test
    public void shouldReturnMax() {

        int[] arr = {16, 14, 10, 8, 7, 9, 3, 2, 4 , 1};
        MaxHeap maxHeap = new MaxHeapImpl(arr);
        assertEquals(16, maxHeap.getMax());
    }

    @Test
    public void shouldDecreaseHeapSizeAfterExtracting() {
        int[] arr = {16, 14, 10, 8, 7, 9, 3, 2, 4 , 1};
        MaxHeap maxHeap = new MaxHeapImpl(arr);
        int oldSize = maxHeap.getHeapSize();
        maxHeap.extractMax();
        assertEquals(oldSize - 1, maxHeap.getHeapSize());
    }

    @Test
    public void shouldExtractMax() {

        int[] arr = {16, 14, 10, 8, 7, 9, 3, 2, 4 , 1};
        MaxHeap maxHeap = new MaxHeapImpl(arr);
        assertEquals(16, maxHeap.extractMax());
    }

    @Test
    public void shouldKeepMaxHeapPropertyAfterExtractMax() {

        int[] arr = {16, 14, 10, 8, 7, 9, 3, 2, 4 , 1};
        MaxHeap maxHeap = new MaxHeapImpl(arr);
        maxHeap.extractMax();
        assertTrue(isHeap(maxHeap.getHeap()));
    }

    @Test
    public void shouldSortArray() {

        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        MaxHeap maxHeap = new MaxHeapImpl(arr);
        maxHeap.buildMaxHeap();
        int[] sorted = maxHeap.heapSort();
        TestUtil.assertSortingProperties(sorted, 0, 10);
    }

    public void shouldReturnCorrectParentIndex() {

    }


    public void shouldReturnCorrectHeapHeight() {

    }

    private static boolean isHeap(int[] arr) {

        int N = arr.length;

        for (int i = (N - 2) / 2; i > -1; --i) { // start from the first internal node who has children;

            int j = 2 * i + 1; // the left child;
            if (j < N - 1 && arr[i] < arr[j+1]) j++; // select the bigger child;
            if (arr[i] < arr[j])
                return false; // if parent is smaller than the child;
        }
        return true;
    }
}
