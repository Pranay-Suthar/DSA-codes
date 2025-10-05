package Math.Easy;

public class Leetcode_231 {
//    Input: n = 1
//    Output: true
//    Explanation: 20 = 1
//    Example 2:
//    Input: n = 16
//    Output: true
//    Explanation: 24 = 16
//    Example 3:
//    Input: n = 3
//    Output: false
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;

        while (n % 2 == 0) {
            n /= 2;
        }

        return n == 1;
    }
}
