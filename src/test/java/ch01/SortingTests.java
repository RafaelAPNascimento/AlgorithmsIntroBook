package ch01;

import _01Foundations.ch01.InsertionSort;
import _01Foundations.ch01.MergeSort;
import _02SortingAndOrderStatistics.QuickSort;
import ch01.util.TestUtil;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static ch01.util.TestUtil.assertSortingProperties;
import static ch01.util.TestUtil.getRandomIntArray;

public class SortingTests {

    @Test
    public void shouldSortByInsertionSort() {

        int[] arr = {10,9,8,7,6,5,4,3,2,1,0};

        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        InsertionSort insertionSort = new InsertionSort(arr);
        insertionSort.insertionSort();

        assertSortingProperties(arr, min, max);
    }

    @Test
    @RepeatedTest(5)
    public void shouldSortByInsertionSort02() {

        int[] arr = getRandomIntArray(50, 200);

        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        InsertionSort insertionSort = new InsertionSort(arr);
        insertionSort.insertionSort();

        assertSortingProperties(arr, min, max);
    }

    @Test
    @RepeatedTest(5)
    public void shouldSortByQuickSort() {

        int[] arr = getRandomIntArray(50, 200);

        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        QuickSort quickSort = new QuickSort(arr);
        quickSort.quickSort();

        assertSortingProperties(arr, min, max);
    }

    @Test
    public void shouldSortByMergeSort() {

        int[] arr = {10,9,8,7,6,5,4,3,2,1,0};

        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();

        MergeSort mergeSort = new MergeSort(arr);
        mergeSort.mergeSort();

        assertSortingProperties(arr, min, max);
    }


}
