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

        int midCol = (startCol + endCol) / 2;
        int maxRowInCol = findMaxInCol(midCol);

        if (midCol > 0 && arr[maxRowInCol][midCol] < arr[maxRowInCol][midCol - 1])
            return findPeak(startCol, midCol - 1);

        else if (midCol + 1 < arr[0].length && arr[maxRowInCol][midCol] < arr[maxRowInCol][midCol + 1])
            return findPeak(midCol + 1, endCol);

        else
            return new int[] {maxRowInCol, midCol};
    }

    private int findMaxInCol(int COL) {

        int maxI = 0;
        for (int row = 1; row < arr.length; row++)
            if (arr[row][COL] > arr[maxI][COL])
                maxI = row;

        return maxI;
    }
}
