
// Example 1:

// Input: s = "ab#c", t = "ad#c"
// Output: true
// Explanation: Both s and t become "ac".
// Example 2:

// Input: s = "ab##", t = "c#d#"
// Output: true
// Explanation: Both s and t become "".
// Example 3:

// Input: s = "a#c", t = "b"
// Output: false
// Explanation: s becomes "c" while t becomes "b".

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_844 {
    public static boolean backspaceCompare(String s, String t) {
        //Time O(n) space O(n)

        // Deque<Character> stackFirst = new ArrayDeque<>();
        // Deque<Character> stackSec = new ArrayDeque<>();

        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);
        //     if(ch == '#'){
        //         if (!stackFirst.isEmpty())
        //             stackFirst.pop();
        //     }
        //     else
        //         stackFirst.push(ch);
        // }

        // for (int i = 0; i < t.length(); i++) {
        //     char ch = t.charAt(i);
        //     if(ch == '#'){
        //         if (!stackSec.isEmpty())
        //             stackSec.pop();
        //     }
        //     else
        //         stackSec.push(ch);
        // }

        // if(stackFirst.size() != stackSec.size())
        //     return false;

        // while (!stackFirst.isEmpty()) {
        //     char ch1 = stackFirst.pop();
        //     char ch2 = stackSec.pop();
        //     if (ch1 != ch2) {
        //         return false;
        //     }
        // }
        // return true;
        int i = s.length() - 1;
        int j = t.length() - 1;

        int countSkipS = 0;
        int countSkipT = 0;
        
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if(s.charAt(i) == '#'){
                    countSkipS++;
                    i--;
                } else if(countSkipS > 0){
                    countSkipS--;
                    i--;
                } else{
                    break;
                }
            }

            while (j >= 0) {
                if(t.charAt(j) == '#'){
                    countSkipT++;
                    j--;
                } else if(countSkipT > 0){
                    countSkipT--;
                    j--;
                } else{
                    break;
                }
            }

            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }

            if ((i >= 0) != (j >= 0)) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s, t));
    }
}
