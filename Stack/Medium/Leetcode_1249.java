

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

        int len = s.length();
        char[] strArr = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] toSkip = new boolean[len];

        for (int i = 0; i < len; i++) {
            char ch = strArr[i];
            if (ch == '(') {
                stack.push(i);
            }
            else if (ch == ')') {
                if (stack.isEmpty())
                    toSkip[i] = true;
                else
                    stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            toSkip[stack.pop()] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {

            if (!toSkip[i]) {
                sb.append(strArr[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "a)b(c)d";

        // String str = "lee(t(c)o)de)";
        //Output: "lee(t(c)o)de"

        System.out.println(minRemoveToMakeValid(str));
    }
}
