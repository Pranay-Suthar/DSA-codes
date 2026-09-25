

// Example 1:

//     Input: heights = [10,6,8,5,11,9]
//     Output: [3,1,2,1,1,0]

//     Explanation:
//     Person 0 can see person 1, 2, and 4.
//     Person 1 can see person 2.
//     Person 2 can see person 3 and 4.
//     Person 3 can see person 4.
//     Person 4 can see person 5.
//     Person 5 can see no one since nobody is to the right of them.

// Example 2:

//     Input: heights = [5,1,2,3,10]
//     Output: [4,1,1,1,0]

    /*A person can see another person to their right in the queue 
    if everybody in between is shorter than both of them.
    More formally, the ith person can see the jth person
    if i < j and min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]). */

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_1944 {
    
    public static int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;
        int[] res = new int[len];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                stack.pop();
                res[i]++;
            }

            if(!stack.isEmpty())
                res[i]++;

            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] heights = {10,6,8,5,11,9};
        //Output : [3,1,2,1,1,0]

        int[] res = canSeePersonsCount(heights);

        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
