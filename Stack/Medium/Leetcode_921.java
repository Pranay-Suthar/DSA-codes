import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_921 {

    public static int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();

        for (char ch : arr) {
            if (!stack.isEmpty() && ch == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {

        // Example 1:
        // Input: s = "())"
        // Output: 1

        // Example 2:
        // Input: s = "((("
        // Output: 3

        String str = "(((";
        System.out.println(minAddToMakeValid(str));
    }
}
