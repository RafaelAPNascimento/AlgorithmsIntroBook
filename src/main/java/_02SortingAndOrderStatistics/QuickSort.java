package _02SortingAndOrderStatistics;

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
            int pv = partition(arr, start, end);
            quickSort(arr, start, pv - 1);
            quickSort(arr, pv + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {

        int avIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end])
                swap(i, avIndex++);
        }
        swap(avIndex, end);
        return avIndex;
    }


    private void swap(int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
