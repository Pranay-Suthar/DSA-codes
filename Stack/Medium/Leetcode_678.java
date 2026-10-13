

// Example 1:

//     Input: s = "()"
//     Output: true

// Example 2:

//     Input: s = "(*)"
//     Output: true

// Example 3:

//     Input: s = "(*))"
//     Output: true

// Example 4:

//     Input: s = "("
//     Output: false

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_678 {
    
    public static boolean checkValidString(String s) {

        Deque<Integer> openBracket = new ArrayDeque<>();
        Deque<Integer> aestrick = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openBracket.push(i);
            } else if (ch == '*') {
                aestrick.push(i);
            } else{
                if (!openBracket.isEmpty()) {
                    openBracket.pop();
                } else if (!aestrick.isEmpty()){
                    aestrick.pop();
                } else{
                    return false;
                }
            }
        }

        while (!openBracket.isEmpty()) {
            if (aestrick.isEmpty()) {
                return false;
            }
            if (openBracket.pop() > aestrick.pop()) {
                return false;
            }
        }
        
        return openBracket.isEmpty();
    }

    public static void main(String[] args) {

        String str = "(*))";

        System.out.println(checkValidString(str));
    }
}
