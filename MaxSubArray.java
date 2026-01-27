public class MaxSubArray {
        //Brute force approach
        public static int maxSubArray1(int nums[]){//Time limit exceeded
            int maxSum = Integer.MIN_VALUE;
            int currSum = 0;

            for(int i = 0; i < nums.length; i++){
                int start = i; // start with 0 for each i
                for(int j = 1; j < nums.length; j++){
                    int end = j;
                    currSum = 0;
                    for(int k = start;k<=end; k++){
                        currSum += nums[k];
                    }
                    maxSum = Math.max(maxSum, currSum);
                }
            }
        return maxSum;
    }

    public static int maxSubArray(int nums[]){
        // //KADANE'S Algo
        // int maxSum = Integer.MIN_VALUE;
        // int currSum = 0;
    
        // for(int i = 0; i<nums.length; i++){ // it fails for nums = {-2, -3}
        //     currSum += nums[i];
        //     if (currSum<0) {
        //         currSum = 0;
        //     }
        //     maxSum = Math.max(maxSum, currSum); 
        // }

        // return maxSum;

        //Updated corrected code
        int maxSum = nums[0];
        int currSum = nums[0];

        for(int i = 1; i<nums.length; i++){
            currSum = Math.max(currSum+nums[i], nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray1(nums));
    }
}
