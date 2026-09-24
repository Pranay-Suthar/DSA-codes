import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode_456
 */

// Example 1:

//     Input: nums = [1,2,3,4]
//     Output: false
//     Explanation: There is no 132 pattern in the sequence.

// Example 2:

//     Input: nums = [3,1,4,2]
//     Output: true
//     Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

// Example 3:

//     Input: nums = [-1,3,2,0]
//     Output: true
//     Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

public class Leetcode_456 {

    public static boolean find132pattern(int[] nums) {

        Deque<Integer> stack = new ArrayDeque<>();
        int len = nums.length;
        int nums3 = Integer.MIN_VALUE;

        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] < nums3) {
                return true;
            }

            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                nums3 = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {3,5,0,3,4};

        System.out.println(find132pattern(nums));
    }
}