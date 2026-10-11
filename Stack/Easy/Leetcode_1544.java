

// Example 1:

//     Input: s = "leEeetcode"
//     Output: "leetcode"
//     Explanation: In the first step, either you choose i = 1 or i = 2,
//     both will result "leEeetcode" to be reduced to "leetcode".

// Example 2:

//     Input: s = "abBAcC"
//     Output: ""
//     Explanation: We have many possible scenarios, and all lead to the same answer. For example:
//     "abBAcC" --> "aAcC" --> "cC" --> ""
//     "abBAcC" --> "abBA" --> "aA" --> ""

// Example 3:

//     Input: s = "s"
//     Output: "s"

public class Leetcode_1544 {

    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && Math.abs(sb.charAt(len - 1) - c) == 32) {
                sb.deleteCharAt(len - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String str = "leEeetcode";

        System.out.println(makeGood(str));
    }
}
