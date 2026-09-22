
// Example 1:

//     Input: heights = [2,1,5,6,2,3]
//     Output: 10
//     Explanation: The above is a histogram where width of each bar is 1.
//     The largest rectangle is shown in the red area, which has an area = 10 units.

// Example 2:

//     Input: heights = [2,4]
//     Output: 4

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_84 {

    public static int largestRectangleArea(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>();
        int maxSize = 0;

        for (int i = 0; i <= heights.length; i++) {

            int curr = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && curr < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int width = i - left - 1;

                int size = width * height;
                maxSize = Math.max(maxSize, size);
            }
            stack.push(i);
        }
        return maxSize;
    }

    public static void main(String[] args) {

        int[] arr = {2,1,5,6,2,3};

        System.out.println(largestRectangleArea(arr));
    }
}
