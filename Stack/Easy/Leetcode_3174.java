

// Example 1:

//     Input: s = "abc"
//     Output: "abc"

//     Explanation:
//         There is no digit in the string.

// Example 2:

//     Input: s = "cb34"
//     Output: ""

//     Explanation:
//         First, we apply the operation on s[2], and s becomes "c4".
//         Then we apply the operation on s[1], and s becomes "".

public class Leetcode_3174 {
    
    public static String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String str = "cb34";

        System.out.println(clearDigits(str));
    }
}
