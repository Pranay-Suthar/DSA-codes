package Math.Easy;

public class Leetcode_13 {
//    Input: s = "III"
//    Output: 3
//    Explanation: III = 3.
//    Example 2:
//    Input: s = "LVIII"
//    Output: 58
//    Explanation: L = 50, V= 5, III = 3.
//    Example 3:
//    Input: s = "MCMXCIV"
//    Output: 1994
//    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
//    Symbol       Value
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

    public static int romanToInt(String s) {
        int sum = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int val = 0;
            char ch = s.charAt(i);

            if (ch == 'I') val = 1;
            if (ch == 'V') val = 5;
            if (ch == 'X') val = 10;
            if (ch == 'L') val = 50;
            if (ch == 'C') val = 100;
            if (ch == 'D') val = 500;
            if (ch == 'M') val = 1000;

            if (val < prev) {
                sum -= val;  // subtract if smaller than the next (right-side) numeral
            } else {
                sum += val;  // otherwise add
            }

            prev = val; // update previous value
        }

        return sum;
    }

}
