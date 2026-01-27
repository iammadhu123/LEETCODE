public class mergeSortedArr {
    public static void merge(int nums1[], int m, int nums2[], int n){//O(n+m)
        int i = m-1, j = n-1, k = m+n-1;
        while (i>=0 && j>=0) {
            if (nums1[i]>=nums2[j]) {
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }

        while (j>=0) {
            nums1[k--] = nums2[j--];
        }

        for(int num: nums1){
            System.out.print(num+" ");
        }

    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        int nums1[] = {1, 2, 3, 0, 0, 0};
        int nums2[] = {2, 5, 6};
        merge(nums1, m, nums2, n);
    }
}



//METHOD 3
        // int j = 0;
        // for(int i = 0; i<n; i++){
        //     nums1[m+i] = nums2[i]; 
        // }

        // Arrays.sort(nums1);