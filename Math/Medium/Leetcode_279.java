package Math.Medium;

public class Leetcode_279 {
//    Input: n = 12
//    Output: 3
//    Explanation: 12 = 4 + 4 + 4.
//    Example 2:
//
//    Input: n = 13
//    Output: 2
//    Explanation: 13 = 4 + 9.
    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }

    public static int numSquares(int n) {
        if (n == 0) return 0;
        int minCount = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; i++) {
            int result = 1 + numSquares(n - (i * i));
            minCount = Math.min(minCount, result);
        }
        return minCount;
    }
}
