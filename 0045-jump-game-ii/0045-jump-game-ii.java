class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxIdx = 0;
        int currentEnd = 0;
        int count = 0;


        for(int i = 0; i<n-1; i++) {
            maxIdx = Math.max(maxIdx, nums[i]+i);

            if(i == currentEnd) {
                count++;
                currentEnd  = maxIdx;
            }
            
        }
        return count;
    }
}