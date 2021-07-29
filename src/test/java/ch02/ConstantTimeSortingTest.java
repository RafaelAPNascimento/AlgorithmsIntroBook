package ch02;

import _02SortingAndOrderStatistics.ConstantTimeSorting;
import _02SortingAndOrderStatistics.RadixSort;
import ch01.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static java.util.Arrays.stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConstantTimeSortingTest {

    @Test
    public void shouldSortByCountingSort() {

        int[] input = {100, 1, 4, 1, 2, 7, 5, 2, 300, 1};
        ConstantTimeSorting countingSort = new ConstantTimeSorting();
        countingSort.countingSort(input, 300);
        Assertions.assertTrue(isSorted(countingSort.getSortedInput()));
    }

    @Test
    public void shouldSortByRadixSort() {

        int[] input = {1, 4, 1, 2, 7, 5, 2, 9,  8, 8, 6, 2, 1};
        ConstantTimeSorting countingSort = new ConstantTimeSorting();
        countingSort.radixSort(input);
        Assertions.assertTrue(isSorted(input));
    }

    @Test
    @RepeatedTest(5)
    public void shouldSortByRadixSort2() {

        int[] input = TestUtil.getRandomIntArray(50, 1_000);
        int min = Arrays.stream(input).min().getAsInt();
        int max = Arrays.stream(input).max().getAsInt();

        ConstantTimeSorting radixSort = new ConstantTimeSorting();

        radixSort.radixSort(input);

        Assertions.assertTrue(isSorted(input), "array is not sorted");
        Assertions.assertEquals(min, input[0]);
        Assertions.assertEquals(max, input[input.length - 1]);
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
