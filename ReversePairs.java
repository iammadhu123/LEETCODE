public class ReversePairs {
    // public static int reversePairs(int nums[]) {
    //     //BRUTE FORCE 
    //     int pairs = 0;
    //     for(int i = 0; i<nums.length-1; i++) {
    //         for(int j = i+1; j<nums.length; j++){
    //             if ((long)nums[i] > 2L*nums[j]) {
    //                 pairs++;
    //             }
    //         }
    //     }
    //     return pairs;
    // }

    //OPTIMAL -> MERGESORT
    public static int mergeSort(int[] nums, int left,int right) {
        if (left>=right) {
            return 0;
        }
        int count = 0;
        int mid = left+(right-left)/2;

        count += mergeSort(nums, left, mid); //left half
        count += mergeSort(nums, mid+1, right); //right half

        count += countPairs(nums, left, mid, right);
        merge(nums, left, mid, right);

        return count;
    }
    public static void merge(int[] nums, int left,int mid, int right) {
        int i = left, j = mid+1;
        int k = 0;
        int temp[] = new int[right-left+1];

        while (i<=mid && j<=right) {
            if (nums[i]<=nums[j]) {
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }

        while (i<=mid) {
            temp[k++] = nums[i++];
        }
        while (j<=right) {
            temp[k++] = nums[j++];
        }

        //copy back
        for(int x = 0; x<temp.length; x++){
            nums[left+x] = temp[x];
        }
    }
    public static int countPairs(int nums[], int left,int mid, int right) {
        int count = 0;
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        return count;
    }
    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    public static void main(String[] args) {
        // int nums[] = {1,3,2,3,1};
        int nums[] = {2,4,3,5,1};
        System.out.println(reversePairs(nums));
        // mergeSort(nums, 0, nums.length-1);

        for (int num : nums) {
            System.out.print(num+ " ");
        }
    }
}


// What is L in 2L ?
// L means long data type literal.
// So:
// 2   → int
// 2L  → long
// int a = 2147483647;
// System.out.println(2 * a);    // wrong (overflow)
// System.out.println(2L * a);   // correct

