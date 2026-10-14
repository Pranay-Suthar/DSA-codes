

// Example 1:

//     Input: s = "(1+(2*3)+((8)/4))+1"
//     Output: 3

//         Explanation:
//         Digit 8 is inside of 3 nested parentheses in the string.

// Example 2:

//     Input: s = "(1)+((2))+(((3)))"
//     Output: 3

//         Explanation:
//         Digit 3 is inside of 3 nested parentheses in the string.

// Example 3:

//     Input: s = "()(())((()()))"
//     Output: 3

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_1614 {
    
    public static int maxDepth(String s) {
        int maxDepth = 0;

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                stack.pop();
            }
            maxDepth = Math.max(maxDepth, stack.size());
        }

        return maxDepth;
    }

    public static void main(String[] args) {

        String str = "";

        System.out.println(maxDepth(str));
    }
}
