import java.util.Arrays;

public class findNextPermutation {
    public static void nextPermutation(int nums[]){ //O(n)
        int i = nums.length-2;
        while (i>=0 && nums[i] >= nums[i+1]) {
            i--;
        }

        if (i>=0) {
            int j = nums.length-1;
            while (nums[i]<nums[j]) {
                j--;
            }
            //swap
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        reverse(nums, i+1, nums.length-1);
    }

    public static void reverse(int nums[], int start, int end){
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int nums[] = {3, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
