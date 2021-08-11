package ch02;

import _02SortingAndOrderStatistics.ConstantTimeSorting;
import _02SortingAndOrderStatistics.RadixSort;
import ch01.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static ch01.util.TestUtil.isSorted;
import static java.util.Arrays.stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ConstantTimeSortingTest {

    @Test
    public void shouldSortByCountingSort() {

        int[] input = {100, 1, 4, 1, 2, 7, 5, 2, 300, 1};
        ConstantTimeSorting countingSort = new ConstantTimeSorting();
        countingSort.countingSort(input, 300);

        Assertions.assertTrue(isSorted(countingSort.getSortedInput()));
        TestUtil.assertRangesInSortedArray(1, 300, countingSort.getSortedInput());
    }


    @Test
    @RepeatedTest(6)
    public void shouldSortByRadixSort2() {

        int initRange = 50, endRange = 1_000;

        int[] input = TestUtil.getRandomIntArray(initRange, endRange);
        int min = Arrays.stream(input).min().getAsInt();
        int max = Arrays.stream(input).max().getAsInt();

        RadixSort radixSort = new RadixSort();

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
        Assertions.assertTrue(TestUtil.isSorted(countingSort.getSortedInputFloats()));
    }

}
