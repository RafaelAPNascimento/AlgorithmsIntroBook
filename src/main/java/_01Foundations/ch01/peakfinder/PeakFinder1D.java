package _01Foundations.ch01.peakfinder;

import java.util.Objects;

/**
 * Given an array of integer, a peak element is the one whose neighbours can not
 * be greater than it. Find peak algorithm should return the array index of any element
 * considered a peak.
 */
public class PeakFinder1D {

    int[] arr;

    public PeakFinder1D(int[] arr) {

        Objects.requireNonNull(arr, "Initial array can't be null");
        this.arr = arr;
    }

    public int findPeak() {
        return findPeak(0, arr.length - 1);
    }

    private int findPeak(int start, int end) {

        if (start + end < 2)
            return arr[start] > arr[end] ? start : end;

        int mid = (end + start) / 2;

        if (arr[mid] < arr[mid - 1])
            return findPeak(start, mid - 1);
        else if (arr[mid] < arr[mid + 1])
            return findPeak(mid + 1, end);
        else
            return mid;
    }
}
