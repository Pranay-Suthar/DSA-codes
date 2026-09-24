import java.util.ArrayDeque;
import java.util.Deque;

// Example 1:

//     Input: prices = [8,4,6,2,3]
//     Output: [4,2,4,2,3]
//     Explanation: 
//     For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4.
//     For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2.
//     For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4.
//     For items 3 and 4 you will not receive any discount at all.

// Example 2:

//     Input: prices = [1,2,3,4,5]
//     Output: [1,2,3,4,5]
//     Explanation: In this case, for all items, you will not receive any discount at all.

// Example 3:

//     Input: prices = [10,1,1,6]
//     Output: [9,0,1,6]

public class Leetcode_1475 {
    
    public static int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = prices[i];
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && res[i] <= res[stack.peek()]) {
                int prevIdx = stack.pop();
                res[prevIdx] -= res[i];
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] arr = {8,4,6,2,5};

        int[] res = finalPrices(arr);

        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
