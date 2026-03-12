public class reverseWordsInStr {
    // public static String reverseWords(String s) {// TC = O(n) SC = O()
    //     s = s.trim().replaceAll("\\s+", " ");

    //     String words[] = s.split(" ");
    //     StringBuilder sb = new StringBuilder();

    //     for(int i = words.length-1; i>=0; i--) {
    //         sb.append(words[i]);
    //         if (i != 0) {
    //             sb.append(" ");
    //         }
    //     }

    //     return sb.toString();
    // }

    public static String reverseWords(String s) {// TC = O(n) SC = O(1)
        s = s.trim().replaceAll("\\s+", " ");
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        int start = 0;
        for(int end = 0; end < sb.length(); end++) {
            if (sb.charAt(end) == ' ') {
                reverse(sb, start, end - 1);
                start = end + 1;
            }
        }
        // Reverse the last word
        reverse(sb, start, sb.length() - 1);

        return sb.toString();
    }
    public static void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
}


// class Solution { // TC = O(n) SC = O(n)
//     public String reverseWords(String s) {
//         s = s.trim().replaceAll("\\s+", " ");
//         String ans = "";

//         for (int i = 0; i < s.length(); i++) {
//             String word = "";

//             while (i < s.length() && s.charAt(i) != ' ') {
//                 word += s.charAt(i);
//                 i++;
//             }

//             if (word.length() > 0) {
//                 ans = word + " " + ans;
//             }
//         }

//         return ans.trim();
//     }
// }
