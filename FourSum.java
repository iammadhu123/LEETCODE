//java.util.Arrays.sort(nums)
import java.util.*;
class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); 

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } 
            for(int j = i+1; j<nums.length-2; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++; 
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--; 
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {2, 2, 2, 2, 2};
        int target = 8;
        System.out.println(fourSum(nums,target));
    }
}

// ⚠️ Remaining Issue: Possible Integer Overflow
// Your code:
// int sum = nums[i] + nums[j] + nums[left] + nums[right];

// ❌ Why this can fail?

// If numbers are large (e.g. 10^9), the sum can overflow int, causing wrong answers.

// ✅ Safe Fix (Recommended):
// long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

