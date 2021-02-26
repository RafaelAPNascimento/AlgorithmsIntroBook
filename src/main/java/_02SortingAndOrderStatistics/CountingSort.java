package _02SortingAndOrderStatistics;

public class CountingSort {

    private int[] inputs;

    private int startRange;
    private int endRange;

    private int[] countArray;
    private int[] sortedInput;

    public CountingSort(int[] arr, int startRange, int endRange) {
        this.inputs = arr;
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public void countingSort() {

        countArray = new int[endRange - startRange + 1];
        fillCountArray(countArray);
        increaseCountArray(countArray);
        placeInputIntoSorted();
    }

    private void fillCountArray(int[] countArray) {

        for (int i = 0; i < inputs.length; i++) {
            if (countArray[inputs[i]] == 0)
                countArray[inputs[i]] = 1;
            else
                countArray[inputs[i]]++;
        }
    }

    private void increaseCountArray(int[] countArray) {

        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
    }

    private void placeInputIntoSorted() {
        sortedInput = new int[inputs.length];
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
