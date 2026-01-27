public class ThirtyFive {
    public static int searchInsert(int nums[], int target){
        int left = 0, right = nums.length - 1;

        while (left<=right) {
            int mid = left+(right-left)/2;

            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid]<target) {
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return left;
    }
    public static void main(String[] args) {
        int nums[] = {1,3,5,6};
        int target = 8;
        System.out.println(searchInsert(nums, target));
    }
}
