import java.util.HashMap;

public class SubArrSum {
    public static int subarraySum(int[] nums, int k){
        //Method 3: OPTIMIZED APPROACH USING PREFIX SUM
        // int n = nums.length;
        // int count = 0;
        // int prefixSum[] = new int[n];
        // prefixSum[0] = nums[0];
        // for(int i = 1; i<n; i++){
        //     prefixSum[i] = prefixSum[i-1] + nums[i];
        // }

        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int j = 0; j<n; j++){
        //     if (prefixSum[j] == k) {
        //         count++;
        //     }else if (map.containsKey(prefixSum[j] - k)) {
        //         count += map.get(prefixSum[j] - k);
        //     }

        //     map.put(prefixSum[j], map.getOrDefault(prefixSum[j], 0) + 1);
        // }

        // return count;


        //METHOD 2: OPTIMIZED APPROACH USING HASHMAP
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//before starting the loop, we assume that the prefix sum 0 has occurred once.
        int count = 0;
        int prefixSum = 0;
        for(int i = 0; i<nums.length; i++){
            prefixSum += nums[i];
            
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum-k);//map.get(prefixSum-k) => Give me how many times the value (prefixSum − k) has appeared before.
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;


        //BRUTE FORCE
        // int n = nums.length;
        // int count = 0;
        // for(int i = 0; i<n; i++){
        //     int sum = 0;
        //     for(int j = i; j<n; j++){
        //         sum += nums[j];
        //         if (sum == k) {
        //             count++;
        //         }
        //     }
        // }
        // return count;
    }
    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 1, 4};
        System.out.println(subarraySum(nums, 2));
    }
}





//  ANOTHER WAY OF WRITING THE SAME CODE

//         HashMap<Integer,Integer> map = new HashMap<>(nums.length);
//         int count = 0;
//         int prefixSum = 0;

//         map.put(0,1);
//         for(int i=0;i<nums.length;i++)
//         {
//             prefixSum += nums[i];
//             int remaining = prefixSum - k;
//             if(map.containsKey(remaining))  
//                 count += map.get(remaining);
            
//             if(map.containsKey(prefixSum))
//             {
//                 int cf = map.get(prefixSum);
//                 map.put(prefixSum, cf+1);
//             }
//             else
//                 map.put(prefixSum,1);
//         }
//         return count;