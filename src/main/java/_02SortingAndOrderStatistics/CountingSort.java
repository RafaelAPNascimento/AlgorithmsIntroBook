package _02SortingAndOrderStatistics;

public class CountingSort {

    private int[] inputs;
    private int[] countArray;
    private int[] sortedInput;

    public CountingSort(int[] arr, int endRange) {
        inputs = arr;
        sortedInput = new int[inputs.length];
        countArray = new int[endRange + 1];
    }

    public void countingSort() {

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

    public int[] getSortedInput() {
        return sortedInput;
    }
}
