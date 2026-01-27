import java.util.Arrays;

public class Permutation {
    public static void reverse(int nums[], int start, int end){
        while (start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void nextPermutation(int nums[]){
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]) {
            i--;
        }
        //step 2
        int j = nums.length-1;
        if(i>=0){
            while (nums[j]<nums[i]) {
                j--;
            }

            //swap
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        reverse(nums, i+1, nums.length-1);

        // for(int num : nums){
        //     System.out.print(num+" ");
        // } //or

        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        int nums[] = {3, 2, 1};
        nextPermutation(nums);
    }
}
