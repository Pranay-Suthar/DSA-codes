// Example 1:

//     Input: s = "(abcd)"
//     Output: "dcba"

// Example 2:

//     Input: s = "(u(love)i)"
//     Output: "iloveu"
//     Explanation: The substring "love" is reversed first, then the whole string is reversed.

// Example 3:

//     Input: s = "(ed(et(oc))el)"
//     Output: "leetcode"
//     Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_1190 {

    public static String reverseParentheses(String s) {

        var stack = new ArrayDeque<Character>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                StringBuilder sb = new StringBuilder();

                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }

                if (stack.peek() == '(') {
                    stack.pop();
                }

                for (int j = 0 ; j < sb.length(); j++) {
                    stack.push(sb.charAt(j));
                }
            } else{
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        String str = "(ed(et(oc))el)";
        // Output: "leetcode"

        System.out.println("Output : " + reverseParentheses(str));
    }
}
