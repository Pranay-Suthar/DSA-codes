
// Example 1:

//     Input: nums = [3,5,2,6], k = 2
//     Output: [2,6]
//     Explanation: Among the set of every possible subsequence: {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]}, [2,6] is the most competitive.

// Example 2:

//     Input: nums = [2,4,3,3,5,4,9,6], k = 4
//     Output: [2,3,3,4]

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_1673 {
    
    public static int[] mostCompetitive(int[] nums, int k) {
        int len = nums.length;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i] && stack.size() + (len - i) > k) {
                stack.pop();
            }
            stack.push(i);
        }

        // System.out.println(stack);

        while (stack.size() > k) {
            stack.pop();
        }

        // System.out.println(stack);

        int[] res = new int[k];
        int idx = k - 1;

        while (!stack.isEmpty()) {
            res[idx] = nums[stack.pop()];
            idx--;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,3,3,5,4,9,6};
        int k = 4;

        int[] res = mostCompetitive(nums, k);

        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
