import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Leetcode_503 {

    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(res, -1);

        for (int i = 0; i < 2 * n; i++) {

            int curr = nums[i % n];

            while (!stack.isEmpty() && curr > nums[stack.peek()]) {
                int poppedIdx = stack.pop();
                res[poppedIdx] = curr;
            }
            
            if(i < n)
                stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,1};
    //     Output: [2,-1,2]
    // Explanation: The first 1's next greater number is 2; 
    // The number 2 can't find next greater number. 
    // The second 1's next greater number needs to search circularly, which is also 2.
    // Example 2:

    // Input: nums = [1,2,3,4,3]
    // Output: [2,3,4,-1,4]

        int[] ans = nextGreaterElements(arr1);

        for (int i : ans) {
            System.out.println(i);
        }
    }
}
