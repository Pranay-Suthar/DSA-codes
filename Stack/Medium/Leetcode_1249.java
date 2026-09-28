

// Example 1:

//     Input: s = "lee(t(c)o)de)"
//     Output: "lee(t(c)o)de"
//     Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

// Example 2:

//     Input: s = "a)b(c)d"
//     Output: "ab(c)d"

// Example 3:

//     Input: s = "))(("
//     Output: ""
//     Explanation: An empty string is also valid.

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_1249 {
    
    public static String minRemoveToMakeValid(String s) {

        int open = 0;
        char[] strArr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < strArr.length; i++) {
            char ch = strArr[i];
            if (ch == '(') {
                open++;
            }
            else if (ch == ')') {
                if (open <= 0) {
                    continue;
                }
                open--;
            }
            stack.push(ch);
        }
        System.out.println(stack);
        
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            if (ch == '(' && open > 0) {
                open--;
                continue;
            }
            sb.append(ch);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "a)b(c)d";

        // String str = "lee(t(c)o)de)";
        //Output: "lee(t(c)o)de"

        System.out.println(minRemoveToMakeValid(str));
    }
}
