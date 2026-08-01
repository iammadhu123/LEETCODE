class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(nums, ans, 0);

        return ans;
        
    }
    public static void helper(int nums[], List<List<Integer>> ans, int idx) {
        if(idx == nums.length) {
            List<Integer> row = new ArrayList<>();
            for(int num: nums) {
                row.add(num);
            }
            ans.add(row);
            return;
        }

        for(int i = idx; i<nums.length; i++) {
            swap(nums, idx, i);
            helper(nums, ans, idx+1);
            swap(nums, idx, i);
        }

    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}