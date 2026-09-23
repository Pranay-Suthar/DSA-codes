
// Example 1:

//     Input: num = "1432219", k = 3
//     Output: "1219"
//     Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

// Example 2:

//     Input: num = "10200", k = 1
//     Output: "200"
//     Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

// Example 3:

//     Input: num = "10", k = 2
//     Output: "0"
//     Explanation: Remove all the digits from the number and it is left with nothing which is 0.

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_402 {

    public static String removeKdigits(String num, int k) {

        int len = num.length();

        if (len == k)
            return "";

        Deque<Character> stack = new ArrayDeque<>();

        int i = 0;
        
        while (k > 0) {

            while (!stack.isEmpty() && num.charAt(i) >= stack.peek()) {
                stack.push(num.charAt(i));
            }
            
            if (!stack.isEmpty() && num.charAt(i) < stack.peek()) {
                k--;
                stack.pop();
                i = num.indexOf(stack.peek());
                continue;
            }
            stack.push(num.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(stack.peek());
        sb.append(num.substring(i, len));

        return sb.toString();

    }

    public static void main(String[] args) {

        // String str = 1432219;
        // int k = 3;
        //Output : 1219
        
        String str = "3238900989831";
        int k = 5;
        //Output : 989831

        System.out.println(removeKdigits(str, k));
    }
}
