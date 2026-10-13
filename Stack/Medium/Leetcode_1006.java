

// Example 1:

//     Input: n = 4
//     Output: 7
//     Explanation: 7 = 4 * 3 / 2 + 1

// Example 2:

//     Input: n = 10
//     Output: 12
//     Explanation: 12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1

public class Leetcode_1006 {
    
    public static int clumsy(int n) {
        int res = 0;
        int sign = 1;

        // (10 * 9 / 8) + (7) - (6 * 5 / 4) + (3) - (2 * 1)
        for (int i = n; i > 0; i-=4) {
            int temp = i;
            if (i - 1 > 0) 
                temp *= i - 1;
            if (i - 2 > 0)
                temp /= i - 2;
            res += sign * temp;
            if (i - 3 > 0) 
                res += i - 3;
            sign = -1;
        }

        return res;
    }

    public static void main(String[] args) {

        int n = 10;

        System.out.println(clumsy(n));
    }
}
