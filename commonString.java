public class commonString {
    public static String commonPrefix(String strs[]){
        if (strs.length == 0 || strs == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        strs[0] = "flower";
        for(int i = 0; i<strs[0].length(); i++){
            char ch = strs[0].charAt(i);
            for(int j = 1; j<strs.length; j++){
                if (i>=strs[j].length() || strs[j].charAt(i) != ch) {
                    return sb.toString();
                }
            }
            sb.append(ch);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String strs[] = {"flower", "flow", "flight"};
        System.out.println(commonPrefix(strs));
    }
}

// 🔹 Real-life example 🧠

// Socho StringBuilder ek chalkboard hai
// Aur String ek final notebook page

// Board pe likhte jao → append()

// Jab kaam khatam → notebook me copy → toString()