package _01Foundations.ch01.peakfinder;

import java.util.Objects;

/**
 * Given a 2D array of integer, a peak is whatever element whose value is greater or
 * equal to its neighbours. A peak in a 2D array can have at most 4 neighbours.
 */
public class PeakFinder2D {

    int[][] arr;

    public PeakFinder2D(int[][] arr) {
        Objects.requireNonNull(arr, "Matrix can not be null");
        this.arr = arr;
    }

    public int[] findPeak() {
        return findPeak(0, arr[0].length - 1);
    }

    private int[] findPeak(int startCol, int endCol) {

        int midCol = (endCol + startCol) / 2;

        int largestRow = findMaxInCol(midCol);

        if (midCol - 1 >= 0 && arr[largestRow][midCol] < arr[largestRow][midCol - 1])
            return findPeak(startCol, midCol - 1);

        else if (midCol < arr.length - 1 && arr[largestRow][midCol] < arr[largestRow][midCol + 1])
            return findPeak(midCol + 1, endCol);

        else
            return new int[] {largestRow, midCol};
    }

    private int findMaxInCol(int COL) {

        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++)
            if (arr[i][COL] > arr[maxIndex][COL])
                maxIndex = i;

        return maxIndex;
    }

}
