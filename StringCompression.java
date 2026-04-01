public class StringCompression {
    public static int compress(char[] chars) {
        int  idx = 0, count = 0;

        int n = chars.length;
        for(int i = 0; i<n; i++) {
            char ch = chars[i];
            count = 1;
            while (i<n && chars[i] == ch) {
                count++;
                i++;
            }

            if (count == 1) {
                chars[idx++] = ch;
            } else {
                chars[idx++] = ch;
                String cntStr = String.valueOf(count);//convert count to string
                for(char dig : cntStr.toCharArray()) {
                    chars[idx++] = dig;
                }
            }
            i--; //decrement i to check for next char in next iteration
        }
        return idx;
    }
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars)); //6
    }
}

// class Solution {
//     public int compress(char[] chars) {
//         int idx = 0; // write pointer
//         int n = chars.length;

//         for (int i = 0; i < n; i++) {
//             char ch = chars[i];
//             int count = 1; // start counting current character

//             // count consecutive duplicates
//             while (i + 1 < n && chars[i + 1] == ch) {
//                 count++;
//                 i++; // move read pointer
//             }

//             // write the character
//             chars[idx++] = ch;

//             // write count digits if more than 1
//             if (count > 1) {
//                 String countStr = String.valueOf(count);
//                 for (char c : countStr.toCharArray()) {
//                     chars[idx++] = c;
//                 }
//             }
//         }

//         return idx; // new length
//     }
// }


// public static int compress(char[] chars) {  //WRONG METHOD
       
//         StringBuilder res = new StringBuilder();

//         int count = 1;
//         for(int i = 1; i<chars.length;  i++) {
//             if (chars[i] == chars[i-1]) {
//                 count++;
//             } else {
//                 res.append(chars[i-1]);
//                 if (count > 1) {
//                     res.append(count);
//                     count = 1;
//                 }
//             }
//         }
//         res.append(chars[chars.length - 1]);
//         if (count > 1) {
//             res.append(count);
//         }
//         System.out.println(res.toString());
//         return res.length();
//     }