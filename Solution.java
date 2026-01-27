import java.util.*;
//class Solution {
    // public static void twoSum(int arr[], int target) {
    //     for(int i = 0; i<arr.length-1; i++) {
    //         for(int j = i+1; j<arr.length; j++) {
    //             if (arr[i]+arr[j] == target) {
    //                 System.out.println("["+i +","+ j+"]");
    //             }
    //         }
    //     }
    // }

    // public static int[] twoSum(int arr[], int target){
    //     for(int i = 0; i<arr.length-1; i++) {
    //         for(int j = i+1; j<arr.length; j++) {
    //             if (arr[i]+arr[j] == target) {
    //                 return new int[]{i,j};
                    // What it means
                    // You are creating an array of size 2
                    // Putting i and j inside it
                    // Returning that array from the method
    //             }
    //         }
    //     }
    //     return new int[]{-1,-1};
    // }
    // public static void main(String[] args) {
    //     int arr[] = {3, 2 ,4 ,6 , 3};
    //     System.out.println(Arrays.toString(twoSum(arr, 6)));

//         Important notes
//         Arrays.toString() is for 1D arrays
//         For 2D arrays → Arrays.deepToString()

// Arrays.toString(...) ❓
// Java cannot directly print arrays in a readable way.
// ❌ If you do this:
// System.out.println(twoSum(arr, 6));
// You’ll get something like:
// [I@6d03e736
// (garbage memory reference)
// ✅ Arrays.toString() converts array → readable string
// Arrays.toString(new int[]{1,2})
//   }
//} 


// HashMap<key, value>
// HashMap<Integer, Integer> map;

// map.put(3, 0);        // store value → index
// map.containsKey(3);  // true/false
// map.get(3);          // returns index

class Solution {
    public static int[] twoSum(int nums[], int target) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int need = target - nums[i];
            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}