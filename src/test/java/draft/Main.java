package draft;

import java.util.*;

import static java.util.Objects.isNull;

public class Main {

	// fazer
	// https://www.simplilearn.com/tutorials/java-tutorial/java-interview-questions
	public static void main(String args[]) {


		int[] arr = {10,9,8,7,6,5,4,3,2,1};
		System.out.println(m(arr, 4));
	}

	// ith largest = N - i
	public static int m(int[] arr, int n) {

		return selectionsort(arr, 0, arr.length - 1, n);
	}

	static int selectionsort(int[] arr, int start, int end, int i) {

		int p = partition(arr, start, end);
		if (p == arr.length - i)
			return arr[p];
		else if (p < arr.length - i)
			return selectionsort(arr, p + 1, end, i);
		else
			return selectionsort(arr, start, p - 1, i);
	}

	static int partition(int[] arr, int start, int end) {
		int avI = start;
		for (int i = start; i < end; i++)
			if (arr[i] < arr[end])
				swapp(arr, i, avI++);

			swapp(arr, avI, end);
			return avI;
	}

	private static void swapp(int[] arr, int i, int i1) {
		int tmp = arr[i];
		arr[i] = arr[i1];
		arr[i1] = tmp;
	}


}
