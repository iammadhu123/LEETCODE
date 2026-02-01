import java.util.Arrays;

public class SlidingWindowMax {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1]; // array to store results

        for (int i = 0; i <= n - k; i++) {
            int max = nums[i]; // assume first element in window is max
            for (int j = i; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j]; // update max if larger element found
                }
            }
            result[i] = max; // store max in result array
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] output = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(output));
    }
}
