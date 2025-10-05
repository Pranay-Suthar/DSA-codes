package Math.Easy;

public class Leetcode_342 {
//    Input: n = 16
//    Output: true
//    Example 2:
//
//    Input: n = 5
//    Output: false
//    Example 3:
//
//    Input: n = 1
//    Output: true
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
    }

    public static boolean isPowerOfFour(int n) {
        if (n <= 0){
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}
