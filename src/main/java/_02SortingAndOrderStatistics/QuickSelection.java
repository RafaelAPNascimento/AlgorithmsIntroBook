package _02SortingAndOrderStatistics;

// also called RandomizedSelection, or SelectionSort
public class QuickSelection {

    private int[] arr;

    public QuickSelection(int[] arr) {
        this.arr = arr;
    }


    public int findKthSmallest(int kth) {

        return quickSelection(arr, 0, arr.length - 1, kth);
    }

    // index = k - 1, k'th smallest
    // index = N - k, k'th greatest
    private int quickSelection(int[] arr, int start, int end, int k) {

        int index = partition(arr, start, end);

        if (index == k - 1)

            return arr[index];

        else if (index < k)
            return quickSelection(arr, index + 1, end, k);

        else
            return quickSelection(arr, start, index - 1, k);
    }


    private int partition(int[] arr, int start, int end) {

        int avIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end])
                swap(arr, i, avIndex++);
        }
        swap(arr, avIndex, end);
        return avIndex;
    }

    private void swap(int[] arr, int i, int j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
