package draft;

import _02SortingAndOrderStatistics.heapSort.MaxHeapImpl;

public class Drafts {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().freeMemory() / 1024);

        int[] c = {1,2,3,4,5,6,7,8,9,0};

        for (int i = 0; i < 100; i++) {
            new MaxHeapImpl(c);
        }
        System.out.println(Runtime.getRuntime().freeMemory() / 1024);
        System.gc();
        System.out.println(Runtime.getRuntime().freeMemory() / 1024);
    }


}