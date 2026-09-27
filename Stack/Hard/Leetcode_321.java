

// Example 1:

//     Input: nums1 = [3,4,6,5], nums2 = [9,1,2,5,8,3], k = 5
//     Output: [9,8,6,5,3]

// Example 2:

//     Input: nums1 = [6,7], nums2 = [6,0,4], k = 5
//     Output: [6,7,6,0,4]

// Example 3:

//     Input: nums1 = [3,9], nums2 = [8,9], k = 3
//     Output: [9,8,9]

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_321 {

    public static int[] merge(int[] a, int[] b) {
        int len1 = a.length;
        int len2 = b.length;
        int[] result = new int[len1 + len2];
        int idx = 0;
        int i = 0;
        int j = 0;

        while (i < len1 || j < len2) {
            if (isGreater(a, i, b, j)) {
                result[idx++] = a[i++];
            } else {
                result[idx++] = b[j++];
            }
        }
        return result;
    }

    private static boolean isGreater(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length) {
            if (a[i] != b[j]) {
                return a[i] > b[j];
            }
            i++;
            j++;
        }
        return (a.length - i) > (b.length - j);
    }

    public static int[] findNum(int[] nums, int k){
        int len = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i] && stack.size() + (len - i) > k) {
                stack.pop();
            }
            stack.push(i);
        }

        while (stack.size() > k) {
            stack.pop();
        }

        int[] res = new int[k];
        int idx = k - 1;

        while (!stack.isEmpty()) {
            res[idx] = nums[stack.pop()];
            idx--;
        }

        return res;
    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int start = Math.max(0, k - len2);
        int end = Math.min(k, len1);

        int[] res = new int[k];

        for (int x = start; x <= end; x++) {
            int[] temp1 = findNum(nums1, x);
            int[] temp2 = findNum(nums2, k - x);

            int[] candidate = merge(temp1, temp2);

            if (isGreater(candidate, 0, res, 0)) {
                res = candidate;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        
        int[] nums1 = {3,4,6,5};
        int[] nums2 = {9,1,2,5,8,3};
        int k = 5;
        //output : {9, 8, 6, 5, 3}

        int[] res = maxNumber(nums1, nums2, k);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
