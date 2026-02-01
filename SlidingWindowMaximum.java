import java.util.*;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int nums[], int k) {
        //NAIVE  APPROACH
        // if (nums == null || k <= 0) {
        //     return new int[0];
        // }
        int n = nums.length;
        // int res[] = new int[n-k+1];
        
        // for(int i = 0; i<n-k+1; i++) { //no. of window n-k+1
        //     int max = nums[i];
        //     for(int j = i+1; j<i+k; j++) {
        //         if (nums[j] > max) {
        //             max = nums[j];
        //         } 
        //     }
        //     res[i] = max;
        // }
        // return res;


        //Optimal Approach (Deque / Monotonic Queue Logic):
        int res[] = new int[n-k+1];
        int j = 0;
        Deque<Integer> dq = new LinkedList<>();
        //Analyze 1st  window
        for(int i = 0; i<k; i++) {
            while (dq.size() > 0 && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        //SWM for another window
        for(int i = k; i<n; i++) {
            res[j++] = nums[dq.peekFirst()];
            //Remove ele which are not part of window
            while (dq.size() > 0 && dq.peekFirst() <= i-k) {
                dq.pollFirst();
            }

            while (dq.size() > 0 && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        res[j++] = nums[dq.peekFirst()];
        return res;
    }
    public static void main(String[] args) {
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}


// 1. Using the Deque Correctly

// In Java, a Deque has these main methods:

// Operation	What it does	Java method you should use
// Access front	Peek first element	dq.peekFirst()
// Remove front	Remove first element	dq.pollFirst()
// Access back	Peek last element	dq.peekLast()
// Remove back	Remove last element	dq.pollLast()
// Add to front	Insert at front	dq.addFirst() / dq.push()
// Add to back	Insert at back	dq.addLast() / dq.offerLast()





// public static List<Integer> maxSlidingWindow(int[] nums, int k) {
//         List<Integer> result = new ArrayList<>();
//         for (int i = 0; i <= nums.length - k; i++) {
//             int max = nums[i];
//             for (int j = i; j < i + k; j++) {
//                 if (nums[j] > max) {
//                     max = nums[j];
//                 }
//             }
//             result.add(max);
//         }
//         return result;
//     }