import java.util.*;

class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {
        int freq[] = new  int[26];
        for(char ch : s1.toCharArray()) {
            freq[ch - 'a']++;
        }

        //Window size = s1.length()
        int windowSize = s1.length();

        for(int i = 0; i<s2.length(); i++ ) {
            int windowIdx = 0, idx = i;
            int freq2[] = new  int[26];
            
            while (windowIdx < windowSize && idx < s2.length()) { //check last k letters
                freq2[s2.charAt(idx) - 'a']++;
                windowIdx++; idx++;
            }

            if (Arrays.equals(freq, freq2)) {
                return true;
            }
        }

        return false;
    }

    // public static boolean checkInclusion(String s1, String s2) {
    //     int freq[] = new  int[26];
    //     for(char ch : s1.toCharArray()) {
    //         freq[ch - 'a']++;
    //     }

    //     int windowSize = s1.length();

    //     for(int i = 0; i<=s2.length() - windowSize; i++) {
    //         int frq2[] = new int[26];

    //         for(int j = 0; j<windowSize; j++) {
    //             frq2[s2.charAt(i+j) - 'a']++;
    //         }

    //         if (Arrays.equals(freq, frq2)) {
    //             return true;
    //         }
    //     }

    //     return false;
    // }

    //BRUTE FORCE
    // public static boolean checkInclusion(String s1, String s2) {// TLE //Time Complexity: O(n * m) where n is the length of s1 and m is the length of s2. This is because we generate all permutations of s1 (which takes O(n!)) and then check if any of those permutations are substrings of s2 (which takes O(m) for each permutation).
    //     Set<String> permutations = new HashSet<>();

    //     // Step 1: generate all permutations of s1
    //     generatePermutations(s1, "", permutations);

    //     // Step 2: check if any permutation exists in s2
    //     for (String perm : permutations) {
    //         if (s2.contains(perm)) {
    //             return true;
    //         }
    //     }

    //     return false;
    // }

    // // helper function to generate permutations
    // public static void generatePermutations(String str, String curr, Set<String> result) {
    //     if (str.length() == 0) {
    //         result.add(curr);
    //         return;
    //     }

    //     for (int i = 0; i < str.length(); i++) {
    //         char ch = str.charAt(i);

    //         String remaining = str.substring(0, i) + str.substring(i + 1);
    //         generatePermutations(remaining, curr + ch, result);
    //     }
    // }

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2)); // true
    }
}