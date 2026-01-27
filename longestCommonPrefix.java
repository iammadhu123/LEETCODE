// Method 1
// class longestCommonPrefix {
//     public static int longCommonPrefix(int[] arr1, int[] arr2) {
//         //String.valueOf(arr1[i]) converts it to "10" (a String)
//         // Now you can access individual digits using s1.charAt(index)

//         int maxLen = 0;
//         for(int i = 0; i<arr1.length; i++){
//             String s1 = String.valueOf(arr1[i]);
//             for(int j = 0; j<arr2.length; j++){
//                 String s2 = String.valueOf(arr2[j]);

//                 int minLen = Math.min(s1.length(), s2.length());
//                 int count  = 0;
//                 for(int k = 0; k<minLen; k++)
//                 if (s1.charAt(k) == s2.charAt(k)) {
//                     count++;
//                 }else{
//                     break;
//                 } 
//                 maxLen = Math.max(maxLen, count);
//             }
//         }
//         return maxLen;
//     }
//     public static void main(String[] args) {
//         int arr1[] = {1, 10, 100};
//         int arr2[] = {1000};
//         System.out.println(longCommonPrefix(arr1, arr2));
//     }
// }


//Optimized method
import java.util.HashSet;

// class longestCommonPrefix {
//     public static int longCommonPrefix(int[] arr1, int[] arr2) {
//         HashSet<Integer> prefixes = new HashSet<>();
        
//         // Step 1: Add all possible prefixes of numbers in arr1 to the set
//         for (int val : arr1) {
//             while (val > 0) {
//                 prefixes.add(val);
//                 val /= 10; // Remove the last digit to get the next prefix
//             }
//         }
        
//         int maxLen = 0;
        
//         // Step 2: Check prefixes of numbers in arr2 against the set
//         for (int val : arr2) {
//             while (val > 0) {
//                 if (prefixes.contains(val)) {
//                     // Calculate length of the current prefix
//                     int currentLen = String.valueOf(val).length();
//                     maxLen = Math.max(maxLen, currentLen);
//                     // If we found a prefix, any smaller prefix of this number 
//                     // won't beat our current maxLen, so we can break.
//                     break; 
//                 }
//                 val /= 10;
//             }
//         }
        
//         return maxLen;
//     }

//     public static void main(String[] args) {
//         int[] arr1 = {1, 10, 100};
//         int[] arr2 = {1000};
//         System.out.println(longCommonPrefix(arr1, arr2)); // Output: 3
//     }
// }

public class longestCommonPrefix {
    public static int longCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixes = new HashSet<>();

        //step1
        for(int num : arr1){
            while (num > 0) {
                prefixes.add(num);
                num /= 10;
            }
        }

        //step2
        int maxLen = 0;
        for (int num : arr2) {
            while (num > 0) {
                if (prefixes.contains(num)) {
                    int currentLen = String.valueOf(num).length();
                    maxLen = Math.max(currentLen, maxLen);
                    break;
                }
                num/= 10;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 10, 100};
        int[] arr2 = {1000};
        System.out.println(longCommonPrefix(arr1, arr2));
    }
}

// Step 1: Build prefixes from arr1
// We use a HashSet<Integer> to store all prefixes obtained by repeatedly removing the last digit.
// For arr1[0] = 1:
// val = 1 → add 1 to prefixes → prefixes = {1}
// val /= 10 → val = 0 → stop

// For arr1[1] = 10:
// val = 10 → add 10 → prefixes = {1, 10}
// val /= 10 → val = 1 → add 1 (already exists)
// val /= 10 → val = 0 → stop

// For arr1[2] = 100:
// val = 100 → add 100 → prefixes = {1, 10, 100}
// val /= 10 → val = 10 → add 10 (already exists)
// val /= 10 → val = 1 → add 1 (already exists)
// val /= 10 → val = 0 → stop
// ✅ After Step 1:
// prefixes = {1, 10, 100}

// Step 2: Check prefixes of arr2 numbers
// For arr2[0] = 1000:
// val = 1000 → is 1000 in prefixes? ❌ No
// val /= 10 → val = 100 → is 100 in prefixes? ✅ Yes
// currentLen = String.valueOf(100).length() = 3
// maxLen = max(0,