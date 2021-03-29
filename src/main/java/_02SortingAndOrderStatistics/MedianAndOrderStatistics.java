package _02SortingAndOrderStatistics;

public class MedianAndOrderStatistics {


    public static void main(String[] args) {

        int[] array = new int[] { 10, 4, 5, 8, 6, 11, 26 };
        int[] arraycopy = new int[] { 10, 4, 5, 8, 6, 11, 26 };

        int kPosition = 5;
        int length = array.length;

        int kThSmalest = randomizedSelect(arraycopy, 0, length - 1, kPosition);
        System.out.println(kThSmalest);
    }

    // finds the kth position (of the sorted array)
    // in a given unsorted array i.e this function
    // can be used to find both kth largest and
    // kth smallest element in the array.
    // ASSUMPTION: all elements in arr[] are distinct

    // impl: https://codingrecipies.blogspot.com/2015/07/algo-121-quick-select-algorithm.html
    // it's also called QUICK-SELECTION algorithm
    public static int randomizedSelect(int[] arr, int low, int high, int k) {

        int len = arr.length;
        if (k > 0 && k <= len) {

            int index = randomizedPartition(arr, low, high);

            if (index + 1 == k)
                return arr[index];

            else if (index < k)
                return randomizedSelect(arr, index + 1, high, k);

            else
                return randomizedSelect(arr, low, index - 1, k);
        }
        return -1;
    }

    // partition function similar to quick sort
    // Considers last element as pivot and adds
    // elements with less value to the left and
    // high value to the right and also changes
    // the pivot position to its respective position
    // in the final array.
    private static int randomizedPartition(int[] arr, int low, int high) {

        int pivotValue = arr[high];
        int storeIndex = low;

        for (int i = low; i < high; i++ ) {

            if (arr[i] <= pivotValue)
                swap(arr, i, storeIndex++);
        }
        if(arr[storeIndex] > arr[high])
            swap(arr, high, storeIndex);

        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
