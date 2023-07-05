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

        List<Float>[] buckets = new List[10];

        for (int i = 0; i < 10; i++) {
            buckets[i] = new LinkedList<>();    // LL takes O(1) to insert elements
        }

        for (Float el : arr) {
            int bucket = (int) (el * 10);
            buckets[bucket].add(el);
        }

        for (List<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        // concatenate all buckets into sortedInput
        sortedInputFloats = new float[arr.length];
        for (int i = 0, c = 0; i < 10; i++) {
            for (Float el : buckets[i]) {
                sortedInputFloats[c++] = el;
            }
        }
    }

    public int[] getSortedInput() {
        return sortedInput;
    }

    public float[] getSortedInputFloats() {
        return sortedInputFloats;
    }
}
