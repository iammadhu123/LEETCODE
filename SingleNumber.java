import java.util.Arrays;
// import java.util.HashMap;

//Leetcode 136 // every element appears twice except for one. 
public class SingleNumber {
    public static int singleNumber(int[] nums){ 
        // HashMap<Integer, Integer> map = new HashMap<>(); //TC = SC = O(n)
        // for(int i = 0; i<nums.length; i++){
        //     if(map.containsKey(nums[i])) {
        //         map.put(nums[i], map.get(nums[i]) + 1);
        //     } else {
        //         map.put(nums[i], 1);
        //     } //OR
        // }

        // for(int num : nums){
        //     map.put(num, map.getOrDefault(num, 0)+1);
        // }

        // for(int key : map.keySet()){
        //     if (map.get(key) == 1) {
        //         return key;
        //     }
        // }
        
        // return -1;

        //METHOD 2
        // int ans = 0;
        // for (int num : nums) {
        //     ans ^= num;
        // }
        // return ans;

        //Method 3
        Arrays.sort(nums);

        int i =  0;
        while (i<nums.length-1) {
            if (nums[i] != nums[i+1]) {
                return nums[i];
            }
            i += 2;
        }

        return nums[nums.length-1];

    }
    public static void main(String[] args) {
        int nums[] = {4, 1, 2, 2, 1, 1};
        System.out.println(singleNumber(nums));
    }
}

// Key Points

// map.keySet() → gives all unique numbers in the array.

// map.get(key) → gives the frequency of that number.

// if(map.get(key) == 1) → checks for the number that appears only once.

// return key → returns the single number.
