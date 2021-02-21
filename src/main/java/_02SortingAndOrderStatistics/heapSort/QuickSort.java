package _02SortingAndOrderStatistics.heapSort;

public class QuickSort {

    int[] arr;

    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    public void quickSort() {
        int start = 0;
        int end = arr.length - 1;
        quickSort(arr, start, end);
    }

    private void quickSort(int[] arr, int start, int end) {

        if (start < end) {
            int p = partition(arr, end);
            quickSort(arr, 0, p - 1);
            quickSort(arr, p + 1, end);
        }
    }

    private int partition(int[] arr, int end) {

        int pv = 0;
        for (int i = 0; i < end; i++) {
            if (arr[i] < arr[end]) {
                swap(i, pv);
                pv++;
            }
        }
        swap(end, pv);
        return end;
    }

    private void swap(int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
