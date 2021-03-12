import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Drafts {

    public static void main(String[] args) throws Exception {

        int[] arr = {170,45,75,90,802,24,2,66};
        radixsort(arr);
        System.out.println(Arrays.toString(arr));
//        int max = Arrays.stream(arr).max().getAsInt();
//
//        for (int exp = 1; max / exp > 0; exp *= 10) {
//
//            System.out.println(exp);
//        }


    }

    // http://www.geekviewpoint.com/java/sorting/radixsort
    static void radixsort(int[] input) {
        final int RADIX = 10;
        // declare and initialize bucket[]
        List<Integer>[] bucket = new ArrayList[RADIX];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        // sort
        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;
            // split input between lists
            for (Integer i : input) {
                tmp = i / placement;
                bucket[tmp % RADIX].add(i);
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }
            // empty lists into input array
            int a = 0;
            for (int b = 0; b < RADIX; b++) {
                for (Integer i : bucket[b]) {
                    input[a++] = i;
                }
                bucket[b].clear();
            }
            // move to next digit
            placement *= RADIX;
        }
    }
}
