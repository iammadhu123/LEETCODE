import java.util.Arrays;

public class Solution {
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void nextPermutation(int nums[]) {
        int i = nums.length-2;
        while (i>=0 && nums[i]>=nums[i+1]) {
            i--;
        }

        if (i>=0) {
            int j = nums.length-1;
            while (nums[j]<=nums[i]) {
                j--;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        reverse(nums, i + 1, nums.length - 1);
    }
    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}