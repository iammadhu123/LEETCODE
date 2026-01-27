import java.util.Arrays;

public class NextPermutation {
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void nextPermutation(int nums[]) {
        int i = nums.length-2;
        while (i>=0 && nums[i]>=nums[i+1]) {//step 1
            i--;
        }

        if (i>=0) {
            //step 2
            int j = nums.length-1;
            while (nums[j]<=nums[i]) {
                j--;
            }

            //swap
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        //Step 3 -> Reverse the right part
        reverse(nums, i + 1, nums.length - 1);
    }
    public static void main(String[] args) {
        int nums[] = {3, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}


// Step 1 Recap
// int i = nums.length - 2;
// while (i >= 0 && nums[i] >= nums[i+1]) {
//     i--;
// }
// This loop finds the first decreasing element from the right.
// Two possibilities:
// i >= 0 → decreasing element found → next bigger permutation exists
// i < 0 → array is completely descending → already largest permutation

// “Next permutation” ka matlab:
// Array ke numbers ko aise rearrange karna, jisse wo lexicographically next bada permutation ho.
// Agar next permutation possible nahi hai (array largest permutation hai) → array ko smallest permutation me change kar do (sort ascending)

// Summary of Algorithm
// Right se first decreasing element find karo
// Right me smallest element > decreasing element find karo → swap
// Reverse elements after original index of decreasing element
// Agar array descending → reverse whole array (smallest permutation)


// ab nums = [3,2,1] dekhte hain.

// Step 1: Right se first decreasing element dhundho

// Array: [3,2,1]

// Right se pairs compare karo:

// 2 > 1 → skip

// 3 > 2 → skip

// ✅ Koi decreasing element nahi mila (array poori descending hai)

// Step 2: Agar descending → reverse whole array

// Reverse [3,2,1] → [1,2,3]

// ✅ Result

// Next permutation = [1,2,3]

// Ye smallest permutation hai, kyunki [3,2,1] already largest permutation tha

// 🔑 Key Idea

// Descending array → largest permutation

// Next permutation possible nahi → return smallest permutation by reversing whole array



// Step 1: Right se first decreasing element find karo

// Right se compare:

// 0 ≥ 0 ❌

// 3 ≥ 0 ❌

// 4 ≥ 3 ❌

// 5 ≥ 4 ❌

// 1 < 5 ✅

// 👉 i = 1, value = 1

// ✅ Step 2: Right side me smallest element > nums[i]

// Right part: [5,4,3,0,0]
// Elements > 1 = 3,4,5

// 👉 smallest greater = 3