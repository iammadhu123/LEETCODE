import java.util.*;
public class ThreeSummation {
    public static List<List<Integer>> threeSum(int nums[]){
        // HashSet<List<Integer>> res = new HashSet<>();
        // for(int i = 0; i<nums.length-1; i++){
        //     Set<Integer> seen = new HashSet<>();
        //     for(int j = i+1; j<nums.length; j++){
        //         int third = -(nums[i]+nums[j]);
        //         if (seen.contains(third)) {
        //             List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);
        //             Collections.sort(triplet);
        //             res.add(triplet);
        //         }
        //         seen.add(nums[j]);
        //     }
        // }
        // return new ArrayList<>(res);

        //Optimal Approach two pointer 
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++){
            if (i>0 && nums[i] == nums[i-1]) {//skip duplicate
                continue;
            }

            int j = i+1;
            int k = nums.length-1;
            while (j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                if (sum < 0) {
                    j++;
                }else if (sum > 0) {
                    k--;
                }else{
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;k--;
                    while (j<k && nums[j] == nums[j-1]) {
                        j++;
                    }
                    while (j<k && nums[k] == nums[k+1]) {
                        k--;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int nums[] = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
