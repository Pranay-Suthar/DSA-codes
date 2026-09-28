

// Example 1:

//     Input: s = "3+2*2"
//     Output: 7

// Example 2:

//     Input: s = " 3/2 "
//     Output: 1

// Example 3:

//     Input: s = " 3+5 / 2 "
//     Output: 5

// Constraints:

//     1 <= s.length <= 3 * 105
//     s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_227 {
    
    public static int calculate(String s) {
        int len = s.length();
        Deque<Integer> stack = new ArrayDeque<>();

        int num = 0;
        char prevSign = '+';

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = (num * 10) + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') || (i == len - 1)) {
                switch (prevSign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }

                prevSign = ch;
                num = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {

        String str = " 1+2+3*5/3+6/4*2";
        //Output : 5

        System.out.println(calculate(str));
    }
}
