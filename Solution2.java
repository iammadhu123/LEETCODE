// import java.util.*;
// class Solution2 {
//     public static int[] merge(int nums1[], int nums2[]) {
//         int temp[] = new int[nums1.length + nums2.length];
//         int i = 0, j = 0, k = 0;
//         while (i < nums1.length && j< nums2.length) {
//             if (nums1[i] < nums2[j]) {
//                 temp[k] = nums1[i];
//                 i++;
//             }else{
//                 temp[k] = nums2[j];
//                 j++;
//             }
//             k++;
//         }
//         //copy remaining elements
//         while (i < nums1.length) {
//             temp[k++] = nums1[i++];
//         }
//         while (j < nums2.length) {
//             temp[k++] = nums2[j++];
//         }
//         return  temp;
//     }
// //Key Median Rules
// // Odd length → middle element
// // Even length → average of two middle elements
//     public static double findMedianSortedArrays(int nums1[], int nums2[]) {
//         int merged[] = merge(nums1, nums2);
//         int n = merged.length;

//         if (n % 2 == 1) { //odd length
//             return merged[n/2];
//         } else {
//             return (merged[n/2-1] + merged[n/2])/2.0;
//         }
//     }
//     public static void main(String[] args) {
//         int nums1[] = {1,2};
//         int nums2[] = {3, 4};
//         System.out.println(Arrays.toString(merge(nums1, nums2)));
//         System.out.println(findMedianSortedArrays(nums1, nums2));
//     }
// }


class Solution2 {
    public static double findMedianSortedArrays(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[] merged = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (a[i] <= b[j]) merged[k++] = a[i++];
            else merged[k++] = b[j++];
        }

        while (i < n) merged[k++] = a[i++];
        while (j < m) merged[k++] = b[j++];

        int len = n + m;
        if (len % 2 == 1) {
            return merged[len / 2];
        } else {
            return (merged[len / 2 - 1] + merged[len / 2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3};
        int[] b = {2};

        System.out.println(findMedianSortedArrays(a, b));
    }
}
