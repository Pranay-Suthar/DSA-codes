
// Example 1:

//     Input: nums = [2,6,4,8,10,9,15]
//     Output: 5
//     Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

// Example 2:

//     Input: nums = [1,2,3,4]
//     Output: 0

// Example 3:

//     Input: nums = [1]
//     Output: 0

public class Leetcode_581 {
    
    public static int findUnsortedSubarray(int[] nums) {

        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        int left = -1;
        int right = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > min) {
                left = i;
            } else {
                min = nums[i];
            }
        }

        return (right == -1) ? 0 : right - left + 1;
    }

    public static void main(String[] args) {

        int[] nums = {2,6,4,8,10,9,15};
        //Output : 5

        System.out.println(findUnsortedSubarray(nums));
    }
}
