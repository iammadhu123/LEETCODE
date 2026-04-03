public class LongestCommonPrefixs {
    public static String longestCommonPrefix(String[] strs) { //TC = O(n*m)
        String prefix = strs[0]; //flower
        
        for(int i = 1; i<strs.length; i++) {
            int j = 0;
            while (j < prefix.length() && j < strs[i].length()) {
                if (strs[i].charAt(j) != prefix.charAt(j)) {
                    break;
                }
                j++;
            }
            prefix = prefix.substring(0, j);
        } 
        return prefix;
    }
    public static void main(String[] args) {
        String str[] = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(str));
    }
}
