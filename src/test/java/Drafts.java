public class Drafts {

    public static void main(String[] args) throws Exception {

        int[] arr5 = {1000, -41, 59, 26, -53, 58, 97, -93, -23, 84};   // 1000
        int[] arr6 = {31, -41, 59, 26, -53, 58, 97, -93, -23, 1000};   // 1061

        //System.out.println(maxSubArray(arr5));
        System.out.println("\n=================");
        System.out.println(maxSubArray(arr6));
    }

    public static int maxSubArray(int[] arr) {
        int result = arr[0];
        int sum = arr[0];

        for(int i=1; i<arr.length; i++){
            sum = Math.max(arr[i], sum + arr[i]);
            result = Math.max(result, sum);
        }

        return result;
    }


}
