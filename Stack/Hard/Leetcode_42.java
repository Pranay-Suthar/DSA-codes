
// Example 1:

//     Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//     Output: 6
//     Explanation: The above elevation map (black section) is represented by 
//     array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

// Example 2:

//     Input: height = [4,2,0,3,2,5]
//     Output: 9

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_42 {

    public static int trap(int[] height) {

        Deque<Integer> stack = new ArrayDeque<>();
        int water = 0;

        for (int i = 0; i < height.length; i++) {
            
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();
                int width = i - left - 1;

                int space = Math.min(height[left], height[i]) - height[bottom];

                water += width * space;
            }
            stack.push(i);
        }

        return water;
    }

    public static void main(String[] args) {

        int[] arr = {4,2,0,3,2,5};

        System.out.println(trap(arr));
    }
}
