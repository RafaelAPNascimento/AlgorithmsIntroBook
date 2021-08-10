package _02SortingAndOrderStatistics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConstantTimeSorting {

    private int[] sortedInput;
    private float[] sortedInputFloats;

    public void countingSort(int[] input, int endRange) {

        int[] countArray = new int[endRange + 1];

        for (int i = 0; i < input.length; i++) {
            countArray[input[i]]++;
        }
        for (int i = 1; i < countArray.length; i++)
            countArray[i] += countArray[i - 1];

        sortedInput = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            int element = input[i];
            int index = --countArray[element];
            sortedInput[index] = element;
        }
    }

    // https://www.tutorialspoint.com/java-program-for-radix-sort
    public void radixSort(int[] arr) {

        sortedInput = new int[arr.length];
        int max = Arrays.stream(arr).max().getAsInt();
        for (int place = 1; max / place > 0; place *= 10)
            countingSortRadixImpl(arr, place);

    }

    private void countingSortRadixImpl(int[] arr, int place) {

        int[] freqs = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int elementPlace = (arr[i] / place) % 10;
            freqs[elementPlace]++;
        }
        for (int i = 1; i < 10; i++)
            freqs[i] += freqs[i - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            int elementPlace = (arr[i] / place) % 10;
            int index = --freqs[elementPlace];
            sortedInput[index] = arr[i];
        }
        System.arraycopy(sortedInput, 0, arr, 0, arr.length);
    }

    public void bucketSort(float[] arr) {

        final int SIZE = arr.length;
        List<Float>[] buckets = new ArrayList[SIZE];

        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new ArrayList<>();

        // put array elements in different buckets
        for (int i = 0; i < SIZE; i++) {
            int index = (int) (arr[i] * SIZE);
            buckets[index].add(arr[i]);
        }

        // sort individual buckets
        for (List bucket : buckets)
            Collections.sort(bucket);

        // concatenate all buckets into sortedInput
        sortedInputFloats = new float[arr.length];
        int index = 0;
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < buckets[i].size(); j++)
                sortedInputFloats[index++] = buckets[i].get(j);
    }

    public int[] getSortedInput() {
        return sortedInput;
    }

    public float[] getSortedInputFloats() {
        return sortedInputFloats;
    }


}
