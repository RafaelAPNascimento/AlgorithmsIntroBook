package _01Foundations.ch01;

public class InsertionSort {

    private int[] arr;

    public InsertionSort(int[] arr) {
        this.arr = arr;
    }

    public void insertionSort() {

        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int key = arr[j];
            while (j > 0 && arr[j - 1] > key) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = key;
        }
    }

}
