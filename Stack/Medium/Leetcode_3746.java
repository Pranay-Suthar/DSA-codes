/**
 * Leetcode_3746
 */


// Example 1:

//     Input: s = "aabbab"
//     Output: 0

//     Explanation:

//         The substring "aabbab" has three 'a' and three 'b'.
//         Since their counts are equal, we can remove the entire string directly.
//         The minimum length is 0.

// Example 2:

//     Input: s = "aaaa"
//     Output: 4

//     Explanation:

//         Every substring of "aaaa" contains only 'a' characters. 
//         No substring can be removed as a result, so the minimum length remains 4.

// Example 3:

//     Input: s = "aaabb"
//     Output: 1

//     Explanation:

//         First, remove the substring "ab", leaving "aab". Next,
//         remove the new substring "ab", leaving "a".
//         No further removals are possible, so the minimum length is 1.

public class Leetcode_3746 {

    public static int minLengthAfterRemovals(String s) {

        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = sb.length();

            if (len > 0) {
                if (sb.charAt(len - 1) == 'a' && ch == 'b' || sb.charAt(len - 1) == 'b' && ch == 'a') {
                    sb.deleteCharAt(len - 1);
                    continue;
                }
            }
            sb.append(ch);
        }
        return sb.length();
    }

    public static void main(String[] args) {

        String str = "aaabba";

        System.out.println(minLengthAfterRemovals(str));
    }
}