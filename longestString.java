import java.util.*;

public class longestString {
    public static int lengthOfLongestSubstring(String str){//Two pointer & sliding window
        if (str.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int left = 0; 
        int right = 0;
        int maxLen = 0;

        while (right<str.length()) {
            if (!set.contains(str.charAt(right))) {
                set.add(str.charAt(right));
                int len = set.size();
                maxLen = Math.max(maxLen, len);
                right++;
            }else{
                set.remove(str.charAt(left));
                left++;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String str = "abc-abcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
