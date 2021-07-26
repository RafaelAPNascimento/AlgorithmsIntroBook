package _02SortingAndOrderStatistics;

import java.util.Arrays;

public class RadixSort {

    public void radixSort(int array[]) {

        int max = Arrays.stream(array).max().getAsInt();

        for (int place = 1; max / place > 0; place *= 10) {
            countingSort(array, array.length, place);
        }
    }

    public void countingSort(int array[], int size, int place) {

        int[] output = new int[size + 1];

        int[] freq = new int[10];

        // Calculate count of elements
        for (int i = 0; i < size; i++) {
            freq[(array[i] / place) % 10]++;
        }
        // Calculate cummulative count
        for (int i = 1; i < 10; i++) {
            freq[i] += freq[i - 1];
        }
        // Place the elements in sorted order
        for (int i = size - 1; i >= 0; i--) {
            int pos = (array[i] / place) % 10;
            output[freq[pos] - 1] = array[i];
            freq[pos]--;
        }

        System.arraycopy(output, 0, array, 0, array.length);
    }
    // Function to get the largest element from an array
    public int getMax(int array[], int n) {
        int max = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
