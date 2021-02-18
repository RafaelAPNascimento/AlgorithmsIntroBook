package ch01;

import _01Foundations.ch01.InsertionSort;
import _01Foundations.ch01.MergeSort;
import _02SortingAndOrderStatistics.heapSort.QuickSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortingTests {

    @Test
    public void shouldSortByInsertionSort() {

        int[] arr = {10,9,8,7,6,5,4,3,2,1,0};
        InsertionSort insertionSort = new InsertionSort(arr);
        insertionSort.insertionSort();

        assertTrue(isSorted(arr));
    }

    @Test
    public void shouldSortByQuickSort() {

        int[] arr = {10,9,8,7,6,5,4,3,2,1,0};
        QuickSort quickSort = new QuickSort(arr);
        quickSort.quickSort();

        assertTrue(isSorted(arr));
    }

    @Test
    public void shouldSortByMergeSort() {

        int[] arr = {10,9,8,7,6,5,4,3,2,1,0};
        MergeSort mergeSort = new MergeSort(arr);
        mergeSort.mergeSort();

        assertTrue(isSorted(arr));
    }

    private boolean isSorted(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }


}
