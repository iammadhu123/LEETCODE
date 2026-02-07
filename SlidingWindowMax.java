// import java.util.Arrays;
import java.util.PriorityQueue;

// public class SlidingWindowMax {
//     public static int[] maxSlidingWindow(int[] nums, int k) {
//         if (nums == null || k <= 0) return new int[0];

//         int n = nums.length;
//         int[] result = new int[n - k + 1]; // array to store results

//         for (int i = 0; i <= n - k; i++) {
//             int max = nums[i]; // assume first element in window is max
//             for (int j = i; j < i + k; j++) {
//                 if (nums[j] > max) {
//                     max = nums[j]; // update max if larger element found
//                 }
//             }
//             result[i] = max; // store max in result array
//         }

//         return result;

//     }

//     public static void main(String[] args) {
//         int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//         int k = 3;

//         int[] output = maxSlidingWindow(nums, k);
//         System.out.println(Arrays.toString(output));
//     }
// }

// // Simple queue → First Come First Serve
// // Priority queue → High priority First Serve

class SlidingWindowMax{
    class Pair implements Comparable<Pair>{
        int idx;
        int val;
        
        Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Pair v2) {
            return v2.val - this.val; // descending
            // return Integer.compare(v2.val, this.val); //to avoid overflow cond
        }
    }

    public int[] maxSlidingWindow(int nums[], int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>(); 

        for(int i = 0; i<k; i++) {
            // pq.add(nums[i]);
            // pq.add(new Pair(i, nums[i]));
            pq.offer(new Pair(i, nums[i]));
        }

        ans[0] = pq.peek().val;

        for(int i = k; i<n; i++) {
            while (!pq.isEmpty() && pq.peek().idx <= i-k) {
                pq.poll();
            }

            // pq.offer(new Pair(nums[i], i));
            pq.offer(new Pair(i, nums[i]));
            ans[i-k+1] = pq.peek().val;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        
        SlidingWindowMax obj = new SlidingWindowMax();
        int result[] = obj.maxSlidingWindow(nums, k);
        System.out.println(result);

        for(int num : result) {
            System.out.print(num + " ");
        }
    }
}

// Overflow se bachne ke liye:

// @Override
// public int compareTo(SlidingWindowMax v2) {
//     return Integer.compare(v2.val, this.val);
// }


// peek() kya karta hai?
// 👉 Top-priority element ko sirf dekhata hai, remove nahi karta

// poll() kya karta hai?
// 👉 Top-priority element ko remove + return karta hai