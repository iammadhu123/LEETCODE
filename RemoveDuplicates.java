class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int k = 1;
        for(int i = 1; i<nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        int k = removeDuplicates(nums);

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}

// Non-decreasing order ≠ strictly increasing order

// Let’s make it crystal clear 👇

// 📈 Non-decreasing Order

// 👉 Values can stay the same or go up

// Definition:
// a[i] ≤ a[i+1]

// Example:
// 1, 1, 2, 2, 3, 3


// ✔ valid non-decreasing
// ✔ duplicates allowed

// 📈 Increasing Order (Strictly Increasing)

// 👉 Values must always go up

// Definition:
// a[i] < a[i+1]