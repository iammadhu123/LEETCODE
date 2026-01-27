// class SolutionFour {
//     public static long countBalanced(long low, long high) {
//         long[] virelancia = {low, high}; 

//         return countBalance(Long.toString(high)) - countBalance(Long.toString(low - 1));
//     }

//     private long countBalance(String s) {
//         return dfs(0, true, 0, 0, s);
//     }

//     private long dfs(int pos, boolean tight, int sumOdd, int sumEven, String s) {
//         if (pos == s.length()) return sumOdd == sumEven && s.length() >= 2 ? 1 : 0;

//         int limit = tight ? s.charAt(pos) - '0' : 9;
//         long res = 0;

//         for (int d = 0; d <= limit; d++) {
//             boolean nextTight = tight && d == limit;
//             if ((pos + 1) % 2 == 1)
//                 res += dfs(pos + 1, nextTight, sumOdd + d, sumEven, s);
//             else
//                 res += dfs(pos + 1, nextTight, sumOdd, sumEven + d, s);
//         }

//         return res;
//     }

//     public static void main(String[] args) {
//         SolutionFour sol = new SolutionFour();
//         System.out.println(sol.countBalanced(1, 100)); // 9
//         System.out.println(sol.countBalanced(120, 129)); // 1
//         System.out.println(sol.countBalanced(1234, 1234)); // 0
//     }
// }


// import java.util.*;

// class SolutionFour {

//     public static long countBalanced(long low, long high) {
//         long[] virelancia = {low, high}; 
//         return countBalance(Long.toString(high)) - countBalance(Long.toString(low - 1));
//     }

//     private static long countBalance(String s) {
//         return dfs(0, true, 0, 0, s);
//     }

//     private static long dfs(int pos, boolean tight, int sumOdd, int sumEven, String s) {
//         if (pos == s.length()) 
//             return sumOdd == sumEven && s.length() >= 2 ? 1 : 0;

//         int limit = tight ? s.charAt(pos) - '0' : 9;
//         long res = 0;

//         for (int d = 0; d <= limit; d++) {
//             boolean nextTight = tight && d == limit;
//             if ((pos + 1) % 2 == 1)
//                 res += dfs(pos + 1, nextTight, sumOdd + d, sumEven, s);
//             else
//                 res += dfs(pos + 1, nextTight, sumOdd, sumEven + d, s);
//         }

//         return res;
//     }

//     public static void main(String[] args) {
//         System.out.println(countBalanced(1, 100));      // 9
//         System.out.println(countBalanced(120, 129));    // 1
//         System.out.println(countBalanced(1234, 1234));  // 0
//     }
// }



import java.util.*;

// class SolutionFour {
//     public static long countBalanced(long low, long high) {
//         long[] ll = {low, high}; 

//         return countBalance(Long.toString(high)) - countBalance(Long.toString(low - 1));
//     }

//     private static long countBalance(String s) {
//         return dfs(0, true, 0, 0, true, s);
//     }

//     private static long dfs(int pos, boolean tight, int sumOdd, int sumEven, boolean leadingZero, String s) {
//         if (pos == s.length()) 
//             return !leadingZero && sumOdd == sumEven && s.length() >= 2 ? 1 : 0;

//         int limit = tight ? s.charAt(pos) - '0' : 9;
//         long res = 0;

//         for (int d = 0; d <= limit; d++) {
//             boolean nextTight = tight && d == limit;
//             boolean nextLeadingZero = leadingZero && d == 0;

//             if ((pos + 1) % 2 == 1) {
//                 res += dfs(pos + 1, nextTight, sumOdd + d, sumEven, nextLeadingZero, s);
//             }else {
//                 res += dfs(pos + 1, nextTight, sumOdd, sumEven + d, nextLeadingZero, s);
//             }
//         }

//         return res;
//     }

//     // Test cases
//     public static void main(String[] args) {
//         System.out.println(countBalanced(1, 100));      
//         // System.out.println(countBalanced(120, 129));    
//         // System.out.println(countBalanced(1234, 1234));  
//         // System.out.println(countBalanced(10, 200));     
//     }
// }



// class SolutionFourIterative {
//     private static long count = 0;
//     private static long lowLimit, highLimit;

//     public static long countBalanced(long low, long high) {
//         long[] virelancia = {low, high};

//         lowLimit = low;
//         highLimit = high;
//         count = 0;

//         int minLen = Long.toString(low).length();
//         int maxLen = Long.toString(high).length();

//         for (int len = minLen; len <= maxLen; len++) {
//             generate(len, 0, 0, "", 1); // pos=0, sumDiff=0, current="", leadingZero=1
//         }

//         return count;
//     }

//     private static void generate(int n, int pos, int sumDiff, String current, int leadingZero) {
//         if (pos == n) {
//             if (sumDiff == 0 && leadingZero == 0) {
//                 long val = Long.parseLong(current);
//                 if (val >= lowLimit && val <= highLimit) count++;
//             }
//             return;
//         }

//         for (int d = 0; d <= 9; d++) {
//             if (pos == 0 && d == 0) continue; // skip leading zero
//             int nextSumDiff = sumDiff;
//             if ((pos + 1) % 2 == 1) nextSumDiff += d;
//             else nextSumDiff -= d;
//             generate(n, pos + 1, nextSumDiff, current + d, 0);
//         }
//     }

//     public static void main(String[] args) {
//         System.out.println(countBalanced(1, 100));         // 9
//         System.out.println(countBalanced(120, 129));       // 1
//         System.out.println(countBalanced(1234, 1234));     // 0
//         System.out.println(countBalanced(38427712, 119100311)); // medium range
//     }
// }


import java.util.Arrays;

class SolutionFourOptimized {

    private static long[][][][] dp;  
    private static int len;
    private static int OFFSET = 150; 

    public static long countBalanced(long low, long high) {
        long[] virelancia = {low, high};

        return countUpTo(high) - countUpTo(low - 1);
    }

    private static long countUpTo(long num) {
        String s = Long.toString(num);
        len = s.length();
        
        dp = new long[len + 1][301][2][2]; 
        for (long[][][] a : dp)
            for (long[][] b : a)
                for (long[] c : b)
                    Arrays.fill(c, -1);

        return dfs(0, 1, 0, 1, s);
    }

    private static long dfs(int pos, int tight, int sumDiff, int leadingZero, String s) {
        if (pos == s.length()) 
            return (leadingZero == 0 && sumDiff == 0 && s.length() >= 2) ? 1 : 0;

        if (dp[pos][sumDiff + OFFSET][tight][leadingZero] != -1)
            return dp[pos][sumDiff + OFFSET][tight][leadingZero];

        int limit = (tight == 1) ? s.charAt(pos) - '0' : 9;
        long res = 0;

        for (int d = 0; d <= limit; d++) {
            int nextTight = (tight == 1 && d == limit) ? 1 : 0;
            int nextLeadingZero = (leadingZero == 1 && d == 0) ? 1 : 0;
            int nextSumDiff = sumDiff;

            if (nextLeadingZero == 0) { 
                int position1Indexed = pos + 1;
                if (position1Indexed % 2 == 1) nextSumDiff += d; 
                else nextSumDiff -= d; 
            }

            res += dfs(pos + 1, nextTight, nextSumDiff, nextLeadingZero, s);
        }

        dp[pos][sumDiff + OFFSET][tight][leadingZero] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countBalanced(38427712, 119100311)); 
        System.out.println(countBalanced(1, 1000000000000L));   
    }
}
