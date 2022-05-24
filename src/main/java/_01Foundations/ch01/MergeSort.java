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
        if (arr.length > 1) {

            int mid = arr.length / 2;
            int[] L = new int[mid];
            int[] R = new int[arr.length - mid];

            for (int i = 0; i < L.length; i++)
                L[i] = arr[i];

            for (int i = 0; i < R.length; i++)
                R[i] = arr[mid + i];

            mergeSort(L);
            mergeSort(R);
            merge(L, R, arr);
        }
    }

    private void merge(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {

            if (left[i] < right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
        while (i < left.length)
            arr[k++] = left[i++];

        while (j < right.length)
            arr[k++] = right[j++];
    }
}
