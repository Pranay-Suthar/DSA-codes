
// Example 1:

//     Input: nums = [6,0,8,2,1,5]
//     Output: 4
//     Explanation: The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] = 0 and nums[5] = 5.

// Example 2:

//     Input: nums = [9,8,1,0,1,9,4,0,4,1]
//     Output: 7
//     Explanation: The maximum width ramp is achieved at (i, j) = (2, 9): nums[2] = 1 and nums[9] = 1.

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_962 {

    public static int maxWidthRamp(int[] nums) {

        Deque<Integer> stack = new ArrayDeque<>();
        int maxWidth = 0;
        int len = nums.length;

        stack.push(0);

        for (int i = 1; i < len; i++) {
            if (nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        // System.out.println(stack);

        int idx = len - 1;

        while (!stack.isEmpty()) {
            if (nums[stack.peek()] <= nums[idx]) {
                maxWidth = Math.max(maxWidth, idx - stack.peek());
                // System.out.println(idx - stack.peek());
                // System.out.println(maxWidth);
                stack.pop();
            } else {
                idx--;
            }
        }

        // System.out.println(stack);

        return maxWidth;
    }

    public static void main(String[] args) {

        int[] arr = {1,9,7,0,6,5,0,7,2,3};
        //Output : 9

        System.out.println(maxWidthRamp(arr));
    }
}
