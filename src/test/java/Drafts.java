public class Drafts {

    public static void main(String[] args) throws Exception {

        System.out.println(partition(6,4));
    }

    static int partition(int n, int m) {

        if (n == 0)
            return 1;
        if (m == 0 || n < 0)
            return 0;
        return partition(n, m - 1) + partition(n - m, m);
    }
}
