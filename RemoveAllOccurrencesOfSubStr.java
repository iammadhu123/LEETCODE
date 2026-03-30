public class RemoveAllOccurrencesOfSubStr {
    // public static String removeOccurrences(String s, String part) {
    //     while (s.contains(part)) {
    //         s = s.replace(part, "");
    //     }
    //     return s;
    // } // Failed Test Case s = "aabababa", part = "aba" → Output: "ab" Expected: "ba"

    // public static String removeOccurrences(String s, String part) {
    //     StringBuilder sb = new StringBuilder(s);

    //     while (sb.indexOf(part) != -1) { //indexOf() is a method used to find the position of a substring or character inside a string.
    //         int idx = sb.indexOf(part);
    //         sb.delete(idx, idx + part.length());
    //     }

    //     return sb.toString();
    // }
    // public static String removeOccurrences(String s, String part) {
    //     int index = s.indexOf(part);
    //     while (index != -1) {
    //         s = s.substring(0, index) + s.substring(index + part.length());
    //         index = s.indexOf(part);
    //     }
    //     return s;
    // }

    public static String removeOccurrences(String s, String part) {
        StringBuilder stack = new StringBuilder();
        for(char c : s.toCharArray()) {
            stack.append(c); //push character into stack one by one
            if (stack.length() >= part.length()) { //check last k letters
                int start = stack.length() - part.length();
                if (stack.substring(start).equals(part)) {
                    stack.delete(start, stack.length()); //if equal → pop them // delete the last k characters from stack till the end of stack
                }
            }
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        String s = "aabababa", part = "aba";//"daabcbaabcbc";
        // String part = "abc";
        System.out.println(removeOccurrences(s, part));
    }
}

// Think of StringBuilder as a stack:

// push character
// check last k letters
// if equal → pop them