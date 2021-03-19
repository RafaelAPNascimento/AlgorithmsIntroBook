public class Drafts {

    public static void main(String[] args) throws Exception {

        int[] arr5 = {1000, -41, 59, 26, -53, 58, 97, -93, -23, 84};   // 1000
        int[] arr6 = {31, -41, 59, 26, -53, 58, 97, -93, -23, 1000};   // 1000

        System.out.println(maxSubArray(arr5));
        System.out.println("\n=================");
        System.out.println(maxSubArray(arr6));
    }

    public static int maxSubArray(int[] nums) {

        int n = nums.length;
        int maximumSubArraySum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int left = 0; left < n; left++) {

            int runningWindowSum = 0;

            for (int right = left; right < n; right++) {
                runningWindowSum += nums[right];

                if (runningWindowSum > maximumSubArraySum) {
                    maximumSubArraySum = runningWindowSum;
                    start = left;
                    end = right;
                }
            }
        }
        System.out.printf("Found Maximum Subarray between %s and %s", start, end);
        return maximumSubArraySum;
    }


}
