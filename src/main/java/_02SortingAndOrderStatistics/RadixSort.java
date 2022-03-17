package _02SortingAndOrderStatistics;

import java.util.Arrays;

public class RadixSort {

    private int[] sorted;

    public void _radixSort(int[] arr) {

        sorted = new int[arr.length];

        int max = Arrays.stream(arr).max().getAsInt();
        for (int place = 1; max / place > 0; place *= 10) {
            countingSort(arr, place);
        }
    }

    private void _countingSort(int[] arr, int place) {

        int[] freq = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int el = (arr[i] / place) % 10;
            freq[el]++;
        }

        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int el = (arr[i] / place) % 10;
            int index = --freq[el];
            sorted[index] = arr[i];
        }

        System.arraycopy(sorted, 0, arr, 0, arr.length);
    }

    public void radixSort(int[] arr) {

        int max = Arrays.stream(arr).max().getAsInt();

        for (int place = 1; max / place > 0; place *= 10) {
            countingSort(arr, place);
        }
    }

    private void countingSort(int[] arr, int place) {

        int[] freq = new int[10];

        for (int i = 0; i < arr.length; i++) {

            int el = (arr[i] / place) % 10;
            freq[el]++;
        }

        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }

        int[] aux = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            int el = (arr[i] / place) % 10;
            int  index = --freq[el];
            aux[index] = arr[i];
        }
        System.arraycopy(aux, 0, arr, 0, arr.length);
    }
}
