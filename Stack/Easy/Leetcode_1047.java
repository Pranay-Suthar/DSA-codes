

// Example 1:

//     Input: s = "abbaca"
//     Output: "ca"
//     Explanation: 
//     For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal,
//     and this is the only possible move.  The result of this move is that the string is "aaca",
//     of which only "aa" is possible, so the final string is "ca".

// Example 2:

//     Input: s = "azxxzy"
//     Output: "ay"

public class Leetcode_1047 {
    
    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == ch) {
                sb.deleteCharAt(len - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String str = "abbaca";

        System.out.println(removeDuplicates(str));
    }
}
