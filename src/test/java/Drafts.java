import java.util.Arrays;

public class Drafts {

    public static void main(String[] args) {

        int[] a = new int[] {1,2,3,4,5,6,0,-1};
        int[] b = Arrays.copyOf(a, a.length);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

}
