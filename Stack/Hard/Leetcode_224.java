

// Example 1:

//     Input: s = "1 + 1"
//     Output: 2

// Example 2:

//     Input: s = " 2-1 + 2 "
//     Output: 3

// Example 3:

//     Input: s = "(1+(4+5+2)-3)+(6+8)"
//     Output: 23

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_224 {
    
    public static int calculate(String s) {

        int len = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        int res = 0;
        int sign = 1;

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if(ch == ' ')
                continue;
            else if (Character.isDigit(ch)) {
                num = (num * 10) + (ch - '0');
            }
            // else if (ch == '+') {
            //     res += (num * sign);
            //     num = 0;
            //     sign = 1;
            // }
            // else if (ch == '-') {
            //     res += (num * sign);
            //     num = 0;
            //     sign = -1;
            // }
            else if (ch == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                num = 0;
                sign = 1;
            } 
            else if (ch == ')') {
                res += num * sign;
                num = 0;

                //Sign "+" or "-"
                res *= stack.pop();

                //Previous Number in stack
                res += stack.pop();
            } else {
                res += (num * sign);
                sign = ch == '+' ? 1 : -1;
                num = 0;
            }
        }

        res += (num * sign);
        return res;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        //Output : 23

        System.out.println(calculate(s));
    }
}
