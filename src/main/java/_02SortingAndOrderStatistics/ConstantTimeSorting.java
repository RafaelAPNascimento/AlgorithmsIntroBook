package _02SortingAndOrderStatistics;

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

        int max = Arrays.stream(arr).max().getAsInt();

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, arr.length, exp);
        }
    }

    private void countingSort(int[] arr, int inputsize, int exp) {

        int result[] = new int[inputsize];
        sortedInput = new int[arr.length];
        int freq[] = new int[10];   // size 10 because decimal values range form 0 - 9

        Arrays.fill(freq, 0);

        for (int i = 0; i < inputsize; i++)
            freq[ (arr[i] / exp) % 10 ]++;

        for (int i = 1; i < 10; i++)
            freq[i] += freq[i - 1];

        for (int i = inputsize - 1; i >= 0; i--) {
            result[freq[ (arr[i] / exp) % 10 ] - 1] = arr[i];
            freq[ (arr[i] / exp) % 10 ]--;
        }
        for (int i = 0; i < inputsize; i++)
            sortedInput[i] = result[i];
    }

    public void bucketSort(float[] arr) {

        final int SIZE = arr.length;
        List<Float>[] buckets = new ArrayList[SIZE];

        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new ArrayList<>();

        // put array elements in different buckets
        for (int i = 0; i < SIZE; i++) {
            float index = arr[i] * SIZE;
            buckets[(int) index].add(arr[i]);
        }

        // sort individual buckets
        for (int i = 0; i < buckets.length; i++)
            Collections.sort(buckets[i]);

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
