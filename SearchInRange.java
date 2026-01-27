import java.util.Arrays;

public class SearchInRange {

    public static int[] searchRange(int[] nums, int target){
        int first = firstOccurrence(nums, target);
        int last = lastOccurrence(nums, target);

        return new int[]{first, last};
    }

    public static int firstOccurrence(int[] nums, int target){
        int left = 0, right = nums.length - 1, ans = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                ans = mid;
                right = mid - 1; // move left
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static int lastOccurrence(int[] nums, int target){
        int left = 0, right = nums.length - 1, ans = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                ans = mid;
                left = mid + 1; // move right
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int nums[] = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target))); // [3, 4]
    }
}

