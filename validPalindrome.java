public class validPalindrome {
    // public static boolean isPalindrome(String s) {
    //     StringBuilder sb = new StringBuilder();
    //     for (char c : s.toCharArray()) {
    //         if (Character.isLetterOrDigit(c)) {
    //             sb.append(Character.toLowerCase(c));
    //         }
    //     }
    //     String cleanedString = sb.toString();
    //     String reversedString = sb.reverse().toString();
    //     return cleanedString.equals(reversedString);
    // }


    // public static boolean isPalindrome(String s){
    //     int left = 0;
    //     int right = s.length()-1;

    //     while (left < right) {
    //         if (!Character.isLetterOrDigit(s.charAt(left))) {
    //             left++;
    //             continue;
    //         }

    //         if (!Character.isLetterOrDigit(s.charAt(right))) {
    //             right--;
    //             continue;
    //         }
    //         //compare
    //         if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
    //             return false;
    //         }

    //         left++;
    //         right--;
    //     }
    //     return true;
    // }
    
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move left pointer to the next alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Move right pointer to the previous alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters at left and right pointers
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false; // Not a palindrome
            }

            left++;
            right--;
        }
        return true; // It's a palindrome
    }
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        // String s = "racecar";
        System.out.println(isPalindrome(s));
    }
}
