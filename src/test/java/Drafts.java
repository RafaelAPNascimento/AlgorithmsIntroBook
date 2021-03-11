import java.util.Arrays;

public class Drafts {

    public static void main(String[] args) throws Exception {

        int[] arr = new int[] {2,5,3,4,2,3,1,3};
        arr = countingSort(arr,5);
        System.out.println(Arrays.toString(arr));
    }

    static int[] countingSort(int[] arr, int maxValue) {

        int[] counter = new int[maxValue + 1];
        int[] sorted = new int[arr.length];

        // count frequency
        for (int i = 0; i < arr.length; i++) {
            counter[arr[i]]++;
        }
        // increment counter[i] by previous
        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i - 1];
        }
        // place into sorted
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            --counter[value];
            int index = counter[value];
            sorted[index] = value;
        }
        return sorted;
    }
}
