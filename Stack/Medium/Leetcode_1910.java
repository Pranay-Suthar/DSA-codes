

// Example 1:

//     Input: s = "daabcbaabcbc", part = "abc"
//     Output: "dab"

//     Explanation: The following operations are done:
//         - s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
//         - s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
//         - s = "dababc", remove "abc" starting at index 3, so s = "dab".
//         Now s has no occurrences of "abc".

// Example 2:

//     Input: s = "axxxxyyyyb", part = "xy"
//     Output: "ab"

//     Explanation: The following operations are done:
//         - s = "axxxxyyyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
//         - s = "axxxyyyb", remove "xy" starting at index 3 so s = "axxyyb".
//         - s = "axxyyb", remove "xy" starting at index 2 so s = "axyb".
//         - s = "axyb", remove "xy" starting at index 1 so s = "ab".
//         Now s has no occurrences of "xy".

public class Leetcode_1910 {

    public static String removeOccurrences(String s, String part) {
        
        StringBuilder sb = new StringBuilder();
        int lenPart = part.length();
        int len = s.length();

        if (len < lenPart) {
            return s;
        }

        for(int i = 0; i < len; i++){
            char ch = s.charAt(i);
            int lenStack = sb.length();

            if (lenStack >= lenPart) {
                String str = sb.substring(lenStack - lenPart);
                if (str.equals(part)) {
                    sb.delete(lenStack - lenPart, lenStack);
                }
            }

            sb.append(ch);
        }

        int lenStack = sb.length();
        if (lenStack > lenPart) {
            String str = sb.substring(lenStack - lenPart);
            if (str.equals(part)) {
                sb.delete(lenStack - lenPart, lenStack);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String str = "ccctltctlltlb";
        String part = "ctl";
        // String str = "axxxxyyyyb";
        // String part = "xy";

        System.out.println(removeOccurrences(str, part));
    }
}
