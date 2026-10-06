class Solution {
    public boolean checkValidString(String s) {
        int openCount = 0;
        int closeCount = 0;

        int length = s.length();

        for(int i = 0; i<length; i++) {

            if(s.charAt(i) == '(' || s.charAt(i) == '*') {
                openCount++;
            } else {
                openCount--;
            }

            if(openCount < 0) {
                return false;
            }

            if(s.charAt(length-i-1) == ')' || s.charAt(length-i-1) == '*') {
                closeCount++;
            } else {
                closeCount--;
            }

            if(closeCount < 0) {
                return false;
            }
        }
        return true;
    }
}