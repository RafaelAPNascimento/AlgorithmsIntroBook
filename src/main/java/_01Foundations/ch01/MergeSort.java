package _01Foundations.ch01;

public class MergeSort {

    int[] arr;

    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    public void mergeSort() {
        mergeSort(arr);
    }

    private void mergeSort(int[] arr) {

        if (arr.length == 1)
            return;

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < left.length; i++)
            left[i] = arr[i];

        for (int i = 0; i < right.length; i++)
            right[i] = arr[i + mid];

        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }

    private void merge(int[] left, int[] right, int[] arr) {

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {

            if (left[i] < right[k]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
