

// Example 1:

//     Input: s = "aabcbc"
//     Output: true

//     Explanation:
//         "" -> "abc" -> "aabcbc" Thus, "aabcbc" is valid.

// Example 2:

//     Input: s = "abcabcababcc"
//     Output: true

//     Explanation: "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
//         Thus, "abcabcababcc" is valid.

// Example 3:

//     Input: s = "abccba"
//     Output: false

//     Explanation: It is impossible to get "abccba" using the operation.

public class Leetcode_1003 {

    public static boolean isValid(String s) {
        
        StringBuilder sb = new StringBuilder(s);
        int start = 0;

        while (start != -1) {
            start = sb.indexOf("abc");
            if (start != -1) {
                sb.delete(start, start + 3);
            }
        }
        return sb.isEmpty();
    }

    public static void main(String[] args) {

        String str = "aabcbc";

        System.out.println(isValid(str));
    }
}
