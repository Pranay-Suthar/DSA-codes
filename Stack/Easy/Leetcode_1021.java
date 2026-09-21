// Example 1:

//     Input: s = "(()())(())"
//     Output: "()()()"
//     Explanation: 
//     The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
//     After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

// Example 2:

//     Input: s = "(()())(())(()(()))"
//     Output: "()()()()(())"
//     Explanation: 
//     The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
//     After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".

// Example 3:

//     Input: s = "()()"
//     Output: ""
//     Explanation: 
//     The input string is "()()", with primitive decomposition "()" + "()".
//     After removing outer parentheses of each part, this is "" + "" = "".

import java.util.ArrayDeque;

public class Leetcode_1021 {

    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;
        char[] arr = s.toCharArray();

        for (char ch : arr) {

            if(ch == '('){
                if (depth > 0) {
                    sb.append(ch);
                }
                depth++;
            } else {
                depth--;
                if (depth > 0) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {

        String str = "(()())(())(()(()))";
        //Output : "()()()()(())"

        System.out.println(removeOuterParentheses(str));
    }
}
