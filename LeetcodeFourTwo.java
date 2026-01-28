public class LeetcodeFourTwo {
    public static int trap(int height[]) {
        //TC = O(n) SC = O(n)
        // int n = height.length;
        // int prefixMax[] = new int[n];
        // prefixMax[0] = height[0];
        // for(int i = 1; i<n; i++) {
        //     prefixMax[i] = Math.max(prefixMax[i-1], height[i]);
        // }
        // int suffixMax[] = new int[n];
        // suffixMax[n-1] = height[n-1];
        // for(int i = n-2; i>=0; i--) {
        //     suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
        // }

        // int trappedWater = 0;
        // for(int i = 0; i<n; i++){
        //     trappedWater += Math.min(suffixMax[i], prefixMax[i]) - height[i];
        // }
        // return trappedWater;

        //TC = O(n) SC = O(1) // Two Pointer Approach
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;
        // while (left < right) {
        //     if(height[left] <= height[right]){
        //         if (leftMax > height[left]) {
        //             trappedWater += leftMax - height[left];
        //         } else {
        //             leftMax = height[left];
        //         }
        //         left++;
        //     } else {
        //         if (rightMax > height[right]) {
        //             trappedWater += rightMax - height[right];
        //         } else {
        //             rightMax = height[right];
        //         }
        //         right--;
        //     }
        // } //or 
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax <= rightMax) {
                trappedWater += leftMax - height[left];
                left++;
            } else {
                trappedWater += rightMax - height[right];
                right--;
            }
        }
        return  trappedWater;
    }

    public static void main(String[] args) {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
