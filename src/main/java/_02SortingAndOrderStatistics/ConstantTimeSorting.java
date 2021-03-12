package _02SortingAndOrderStatistics;

public class ConstantTimeSorting {

    private int[] sortedInput;

    public void countingSort(int[] arr, int endRange) {

        int[] inputs = arr;
        int[] countArray = new int[endRange + 1];
        sortedInput = new int[inputs.length];

        // count inputs frequency
        for (int i = 0; i < inputs.length; i++)
            countArray[inputs[i]]++;

        // increment countArray
        for (int i = 1; i < countArray.length; i++)
            countArray[i] += countArray[i - 1];

        // place into sorted order
        for (int i = 0; i < sortedInput.length; i++) {
            int input = inputs[i];
            int position = countArray[input];
            sortedInput[--position] = input;
            countArray[input]--;
        }
    }

    public void radixSort(int[] arr) {

        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            //countingSort(arr, arr.length, exp);
        }
    }

    private int[] countinSortForRadix(int[] arr, int placeValue) {

        int range = 10;

        return null;
    }

    private int getMax(int[] arr) {
        return 0;
    }

    public int[] getSortedInput() {
        return sortedInput;
    }
}
