

// Example 1:

//     Input: nums = [1,2,3]
//     Output: 4
//     Explanation: The 6 subarrays of nums are the following:
//     [1], range = largest - smallest = 1 - 1 = 0 
//     [2], range = 2 - 2 = 0
//     [3], range = 3 - 3 = 0
//     [1,2], range = 2 - 1 = 1
//     [2,3], range = 3 - 2 = 1
//     [1,2,3], range = 3 - 1 = 2
//     So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.

// Example 2:

//     Input: nums = [1,3,3]
//     Output: 4
//     Explanation: The 6 subarrays of nums are the following:
//     [1], range = largest - smallest = 1 - 1 = 0
//     [3], range = 3 - 3 = 0
//     [3], range = 3 - 3 = 0
//     [1,3], range = 3 - 1 = 2
//     [3,3], range = 3 - 3 = 0
//     [1,3,3], range = 3 - 1 = 2
//     So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.

// Example 3:

//     Input: nums = [4,-2,-3,4,1]
//     Output: 59
//     Explanation: The sum of all subarray ranges of nums is 59.

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_2104 {

    public static long findMinimum(int[] nums) {
        int n = nums.length;
        long sum = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] > nums[i])) {

                int mid = stack.pop();

                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long leftChoices = mid - left;
                long rightChoices = right - mid;

                sum += (long) nums[mid] * leftChoices * rightChoices;
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return sum;
    }

    public static long findMaximum(int[] nums) {
        int n = nums.length;
        long sum = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] < nums[i])) {

                int mid = stack.pop();

                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long leftChoices = mid - left;
                long rightChoices = right - mid;

                sum += (long) nums[mid] * leftChoices * rightChoices;
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return sum;
    }

    public static long subArrayRanges(int[] nums) {
        return findMaximum(nums) - findMinimum(nums);
    }

    public static void main(String[] args) {

        int[] nums = {4,-2,-3,4,1};

        System.out.println(subArrayRanges(nums));
    }
}
