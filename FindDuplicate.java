import java.util.Arrays;

public class FindDuplicate {
    public static int findDuplicate(int nums[]){
        // Arrays.sort(nums);

        // for(int i = 1; i<nums.length; i++){
        //     if (nums[i] == nums[i-1]) {
        //         return nums[i];
        //     }
        // }
        // return -1;

        //FLOYD'S CYCLE DETECTION ALGORITHM
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);

        slow = nums[0];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        } 

        return slow;
    }
    public static void main(String[] args) {
        int nums[] = {1,3,4,2,5,5};
        System.out.println(findDuplicate(nums));
    }
}

// 🧠 Core Idea (Why Duplicate MUST Exist)
// This is Pigeonhole Principle:
// You have n + 1 numbers
// But only n possible values (1 → n)
// So at least one value must repeat
// ✔️ Proven.

// ✅ Optimal Solution: Floyd’s Cycle Detection (Tortoise & Hare)
// 🔁 Why This Works
// Treat array as a linked list
// Each index points to nums[index]
// Duplicate creates a cycle
// Finding cycle entrance = duplicate number