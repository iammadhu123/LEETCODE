import java.util.HashMap;

class FourSumTwo {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i<nums1.length; i++){
            for(int j = 0; j<nums2.length; j++){
                int sum1 =nums1[i]+nums2[j];
                map.put(sum1, map.getOrDefault(sum1, 0) + 1);
            }
        }

        int count = 0;
        for(int i = 0; i<nums3.length; i++){
            for(int j = 0; j<nums4.length; j++){
                int sum2 = nums3[i]+nums4[j];
                count += map.getOrDefault(-(sum2), 0);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int nums1[] = {1,2};
        int nums2[] = {-2,-1};
        int nums3[] = {-1,2};
        int nums4[] = {0,2};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }
}

// map.getOrDefault(a + b, 0)

// Tries to get the current count of that sum

// If the sum does not exist, it returns 0

// Example:

// map.getOrDefault(0, 0) → 0
// map.getOrDefault(1, 0) → 1   (if already present)


// Equivalent (Long Form)

// If this line feels confusing, here’s the same logic written clearly:

// int sum = a + b;
// if (map.containsKey(sum)) {
//     map.put(sum, map.get(sum) + 1);
// } else {
//     map.put(sum, 1);
// }