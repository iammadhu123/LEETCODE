import java.util.Arrays;

public class ProductOfArrExceptSelf {
    public static int[] productExceptSelf(int[] nums){
        // int n = nums.length;
        //prefix
        // int ans[] = new int[n]; 
        // ans[0] = 1;
        // for(int i = 1; i<n; i++){
        //     ans[i] = ans[i-1] * nums[i-1];
        // }
        // //suffix
        // int suffix[] = new int[n];
        // suffix[n-1] = 1;
        // for(int i = n-2; i>=0; i--){
        //     suffix[i] = suffix[i+1] * nums[i+1];
        // }

        // for(int i = 0; i<n; i++){
        //     ans[i] = ans[i] * suffix[i];
        // }

        // return ans;

        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Prefix products
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }

        // Step 2: Suffix products
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
