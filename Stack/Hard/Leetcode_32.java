import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode_32
 */

// Example 1:

//     Input: s = "(()"
//     Output: 2
//     Explanation: The longest valid parentheses substring is "()".

// Example 2:

//     Input: s = ")()())"
//     Output: 4
//     Explanation: The longest valid parentheses substring is "()()".

// Example 3:

//     Input: s = ""
//     Output: 0

public class Leetcode_32 {

    public static int longestValidParentheses(String s) {
        
        if(s.length() <= 1)
            return 0;

        int size = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {

                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int currSize = i - stack.peek();

                    size = Math.max(size, currSize);
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {

        // String str = ")()())";
        String str = "(())()())";

        System.out.println(longestValidParentheses(str));
    }
}