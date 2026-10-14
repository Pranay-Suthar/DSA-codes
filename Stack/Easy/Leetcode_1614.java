

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

public class Leetcode_1614 {
    
    public static int maxDepth(String s) {
        int maxDepth = 0;
        int depth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                depth++;
            } else if (ch == ')') {
                depth--;
            }
            maxDepth = Math.max(maxDepth, depth);
        }

        return maxDepth;
    }

    public static void main(String[] args) {

        String str = "(-/6)4((*9(8(())4)))";
        //Output : 5

        System.out.println(maxDepth(str));
    }
}
