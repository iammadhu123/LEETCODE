public class CountingInversions {
    // public static int countInversion(int nums[]){
        // Brute force O(n^2)
        // int n = nums.length;
        // int count = 0;
        // for (int i = 0; i<n-1; i++) {
        //     for(int j = i+1; j<n; j++) {
        //         if (nums[i] > nums[j]) {
        //             // int temp = nums[i];
        //             // nums[i] = nums[j];
        //             // nums[j] = temp;
        //             count++;
        //         }
        //     }
        // }
        // return count; 
    // }

    //Optimized - Merge sort  
    public static int mergeSort(int nums[], int si, int ei){    
        int invCount = 0;

        if (si < ei) {
            int mid = si + (ei - si) / 2;
            invCount += mergeSort(nums, si, mid);
            invCount += mergeSort(nums, mid + 1, ei);
            invCount += merge(nums, si, mid, ei);
        }

        return invCount;
    }

    public static int merge(int nums[], int si, int mid, int ei){
        int i = si; int j = mid+1; int k = 0;  int invCount = 0;
        int temp[] = new int[ei-si+1];

        while (i <= mid && j <= ei) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            }else{
                invCount += mid-i+1; //KEY POINTS
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= ei) {
            temp[k++] = nums[j++];
        }

        // // copy back
        for (int m = 0; m < temp.length; m++) {
            nums[si + m] = temp[m];
        }
        return invCount;
    }
    public static void main(String[] args) {
        int nums[] = {2,1,3,1,2};
        System.out.println(mergeSort(nums, 0, nums.length-1));
    }
}
