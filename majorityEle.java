// import java.util.HashMap;
// import java.util.Map;

import java.util.Arrays;

public class majorityEle {
    // public static int majorityElement(int nums[]){
    //     int n = nums.length/2;
    //     HashMap<Integer,Integer> map = new HashMap<>();
        
    //     for (int num : nums) {
    //         map.put(num, map.getOrDefault(num, 0)+1);
    //     }

    //     for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //         if (entry.getValue() > n) {
    //             return entry.getKey();
    //         }
    //     }
        
    //     return -1;
    // }

    //Bruteforece => O(n^2)
    // public static int majorityElement(int nums[]){
    //     int n = nums.length/2;

        // int count = 0;
        // for(int i = 0; i<nums.length-1; i++){
        //     count = 1;
        //     for(int j = i+1; j<nums.length; j++){
        //         if (nums[i] == nums[j]) {
        //             count++;
        //         }
        //     }
        //     if (count>n) {
        //         return nums[i];
        //     }
        // } //   OR

    //     for (int val : nums) {
    //         int freq = 0;
    //         for (int ele : nums) {
    //             if (ele == val) {
    //                 freq++;
    //             }
    //         }
    //         if (freq>n) {
    //             return val;
    //         }
    //     }
    //     return -1;
    // }

    // public static int majorityElement(int nums[]){//Optimized => O(nlogn)
    //     if(nums.length == 1){
    //         return nums[0];
    //     }
    //     Arrays.sort(nums);//Sorting → O(n log n)
    //     int n = nums.length;

    //     int ans = nums[0];
    //     int freq = 1;

    //     //Loop to count frequency → O(n)
    //     for(int i = 1; i<n; i++){
    //         if (nums[i] == ans) {
    //             freq++;
    //         }else{
    //             freq = 1;
    //             ans = nums[i];
    //         }
    //         if (freq>n/2) {
    //             return ans;
    //         }
    //     }

    //     return -1;
    // }

    public static int majorityElement(int nums[]) {//Boyer-Moore =? O(n); sc => O(1)
        int freq = 0, ans = 0;

        for(int i = 0; i<nums.length; i++) {
            if (freq == 0) {
                ans = nums[i];
            }
            if (ans == nums[i]) {
                freq++;
            }else{
                freq--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {2};
        System.out.println(majorityElement(nums));
    }
}

// Problem:

// Input: [1] → n = 1, n/2 = 0 (integer division)

// Loop never increments freq beyond n/2? Let’s check:

// ans = 1
// freq = 1
// i = 1 → loop doesn't run because n = 1


//CORRECT WAY TO USE ELSE IF
// public static int majorityElement(int nums[]) {
//     int freq = 0, ans = 0;

//     for(int num : nums){
//         if(freq == 0){
//             ans = num;
//             freq = 1; // directly set freq = 1
//         } else if(num == ans){
//             freq++;
//         } else {
//             freq--;
//         }
//     }

//     return ans;
// }
