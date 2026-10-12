

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

        while (s.contains("abc")) {
            s = s.replace("abc", "");
        }

        return s.length() == 0;
    }

    public static void main(String[] args) {

        String str = "aabcbc";

        System.out.println(isValid(str));
    }
}
