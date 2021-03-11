package ch02;

import _02SortingAndOrderStatistics.ConstantTimeSorting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CountingSortTest {

    @Test
    public void test01() {

        int[] input = {1, 4, 1, 2, 7, 5, 2, 9, 1};
        ConstantTimeSorting countingSort = new ConstantTimeSorting();
        countingSort.countingSort(input, 9);
        Assertions.assertTrue(isSorted(countingSort.getSortedInput()));
    }

    private boolean isSorted(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }
}