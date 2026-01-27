//import java.util.*;
public class practice {
    public static String commonString(String str[]){
        // String cStr = "";
        // //str[0] = "flower";
        // for(int i = 1; i<str.length; i++){
        //     if (str[0].charAt(0) == str[i].charAt(0)) {
        //         cStr += 
        //     }
        // }
        if (str  == null || str.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str[0].length(); i++) {
            char ch = str[0].charAt(i);

            for (int j = 1; j < str.length; j++) {
                if (i >= str[j].length() || str[j].charAt(i) != ch) {
                    return result.toString();
                }
                //toString() mutable StringBuilder → immutable String convert karta hai
            }
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str[] = {"flower", "flow", "fly"};
        System.out.println(commonString(str));
    }
}

// Strings: {"flower", "flow", "fly"}
// i = 3, ch = 'w' (from "flower")
// str[1].charAt(3) = 'w' ✅ match
// str[2].charAt(3) ❌ out of bounds (length = 3)

// char ch = str[0].charAt(i);
// charAt(i) → index i ka character nikalta hai
// ch me store ho jata hai
