import java.util.*;

//brute force => O(n^3)
class threeSum {
    public static List<List<Integer>> sumOfThree(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>(); // to avoid duplicates

        int n = nums.length;
        Arrays.sort(nums); // optional for consistent order

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        String key = nums[i] + "," + nums[j] + "," + nums[k];
                        if (!set.contains(key)) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                            set.add(key);
                        }
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = sumOfThree(nums);

        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}

//Optimized approach => O(n^2)
// class threeSum {
//     public static List<List<Integer>> threeSum1(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         Arrays.sort(nums); // Sort the array to use two-pointer technique

//         for (int i = 0; i < nums.length - 2; i++) {// Skip duplicates for the first number
//             if (i > 0 && nums[i] == nums[i - 1]) {
//                 continue;
//             } 

//             int left = i + 1;
//             int right = nums.length - 1;

//             while (left < right) {
//                 int sum = nums[i] + nums[left] + nums[right];
//                 if (sum == 0) {
//                     result.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                     while (left < right && nums[left] == nums[left + 1]) {
//                         left++; // Skip duplicates for the second number
//                     }
//                     while (left < right && nums[right] == nums[right - 1]) {
//                         right--; // Skip duplicates for the third number
//                     }
//                     left++;
//                     right--;
//                 } else if (sum < 0) {
//                     left++;
//                 } else {
//                     right--;
//                 }
//             }
//         }
//         return result;
//     }

//     public static void main(String[] args) {
//         int nums[] = {-1, 0, 1, 2, -1, -4};
//         System.out.println(threeSum1(nums));
//     }
// }


// List<List<Integer>> result = new ArrayList<>();
// List<Integer>
// Represents a list of integers, e.g., [1, 2, 3].
// List<Integer> singleTriplet = new ArrayList<>();
// singleTriplet.add(1);
// singleTriplet.add(2);
// singleTriplet.add(3);

// List<List<Integer>>
// Represents a list of lists.
// In your 3Sum problem, each triplet [a, b, c] is a List<Integer>.
// All triplets together form a List<List<Integer>>.