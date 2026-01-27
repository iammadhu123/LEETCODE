import java.util.Arrays;

public class threeSumClose {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int resultSum = nums[0]+nums[1]+nums[2];//or 0
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i<nums.length; i++) {
            int left = i+1;
            int right = nums.length-1;

            while (left<right) {
                int sum = nums[i]+nums[left]+nums[right];
                int diff = Math.abs(sum-target);
                if (diff<minDiff) {
                    resultSum = sum;
                    minDiff = diff;
                }else if(sum<target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return resultSum;
    }
    public static void main(String[] args) {
        int nums[] ={-1,2, 1, -4};
        // int nums[] = {1,1,1,0};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}

// Input: [1,1,1,0], -100
// Output: 3
// Expected: 2 