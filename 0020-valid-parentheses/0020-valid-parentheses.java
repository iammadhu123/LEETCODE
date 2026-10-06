// class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> stack = new Stack<>();

//         for (char ch : s.toCharArray()) { //toCharArray() converts:['(', '{', '[', ']', '}', ')']

//             if (ch == '(' || ch == '{' || ch == '[') {
//                 stack.push(ch);

//             } else {
//                 if (stack.isEmpty()) {
//                     return false;
//                 }

//                 char top = stack.pop();

//                 if ((ch == ')' && top != '(') || 
//                   (ch == '}' && top != '{') || 
//                   (ch == ']' && top != '[')) {
//                     return false;
//                 }
//             }
//         }

//         return stack.isEmpty();
//     }
// }

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.pop() != map.get(ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }
}

// // map.get() is used to get the value associated with a key
