package ch02;

import _02SortingAndOrderStatistics.ConstantTimeSorting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Collections;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConstantTimeSortingTest {

    @Test
    public void shouldSortByCountingSort() {

        int[] input = {1, 4, 1, 2, 7, 5, 2, 9, 1};
        ConstantTimeSorting countingSort = new ConstantTimeSorting();
        countingSort.countingSort(input, 9);
        Assertions.assertTrue(isSorted(countingSort.getSortedInput()));
    }

    @Test
    public void shouldSortByRadixSort() {

        int[] input = {1, 4, 1, 2, 7, 5, 2, 9, 1};
        ConstantTimeSorting countingSort = new ConstantTimeSorting();
        countingSort.radixSort(input);
        Assertions.assertTrue(isSorted(countingSort.getSortedInput()));
    }

    @Test
    public void shouldSortByBucketSort() {

        float[] input = {(float) 0.897, (float) 0.565, (float) 0.656, (float) 0.1234, (float) 0.665, (float) 0.3434};
        ConstantTimeSorting countingSort = new ConstantTimeSorting();
        countingSort.bucketSort(input);
        Assertions.assertTrue(isSorted(countingSort.getSortedInputFloats()));
    }



    private boolean isSorted(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }

    private boolean isSorted(float[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }
}
