import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * Leetcode_498
 */
public class Leetcode_498 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];
        
        Deque<Integer> stack = new ArrayDeque<>();
        var map = new HashMap<Integer, Integer>();

        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {4,1,2};
        int[] arr2 = {1,3,4,2};
        // Output : [-1,3,-1]

        // Input: nums1 = [2,4], nums2 = [1,2,3,4]
        // Output: [3,-1]

        int[] ans = nextGreaterElement(arr1, arr2);

        for (int i : ans) {
            System.out.println(i);
        }

    }
}