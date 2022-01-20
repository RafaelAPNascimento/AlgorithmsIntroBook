package _02SortingAndOrderStatistics;

import java.util.*;

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

    public void bucketSort(float[] arr) {

        final int SIZE = arr.length;
        List<Float>[] buckets = new LinkedList[SIZE];

        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new LinkedList<>();        // LL takes O(1) to insert elements

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
