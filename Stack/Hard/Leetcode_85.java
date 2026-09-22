
// Example 1:

//     Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
//     Output: 6
//     Explanation: The maximal rectangle is shown in the above picture.

// Example 2:

//     Input: matrix = [["0"]]
//     Output: 0

// Example 3:

//     Input: matrix = [["1"]]
//     Output: 1

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_85 {

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

    public static int maximalRectangle(char[][] matrix) {

        int maxSize = 0;
        int[] arr = new int[matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    arr[j]++;
                } else{
                    arr[j] = 0;
                }
            }
            maxSize = Math.max(maxSize, largestRectangleArea(arr));
        }
        return maxSize;
    }

    public static void main(String[] args) {

        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };

        System.out.println(maximalRectangle(matrix));
    }
}
