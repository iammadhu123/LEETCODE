import java.util.Arrays;

public class validAnagram {
    // public static boolean isAnagram(String s, String t) { //TC = O(n log n) SC = O(n)
    //     char[] s1 = s.toCharArray();
    //     Arrays.sort(s1);

    //     char[] t1 = t.toCharArray();
    //     Arrays.sort(t1);

    //     String sorted1 = new String(s1);
    //     String sorted2 = new String(t1);

    //     return sorted1.equals(sorted2);
    // }

    public static boolean isAnagram(String s, String t) { //TC = O(n) SC = O(1)
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount1 = new int[26];
        // Count the occurrences of each character in s
        for(char c : s.toCharArray()) {
            charCount1[c - 'a']++;
        }

        // Decrement the counts based on characters in t
        for(char c : t.toCharArray()) {
            charCount1[c - 'a']--;
        }
        
        // Check if all counts are zero
        for(int count : charCount1) {
            if (count != 0) {
                return false; //Not an anagram
            }
        }

        return true; //Is an anagram
    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
