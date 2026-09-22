import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Leetcode_739
 */

// Example 1:

//     Input: temperatures = [73,74,75,71,69,72,76,73]
//     Output: [1,1,4,2,1,1,0,0]

// Example 2:

//     Input: temperatures = [30,40,50,60]
//     Output: [1,1,1,0]

//     Example 3:

//     Input: temperatures = [30,60,90]
//     Output: [1,1,0]

public class Leetcode_739 {

    public static int[] dailyTemperatures(int[] temperatures) {

        int[] ans = new int[temperatures.length]; 
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {

            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int prevIdx = stack.pop();
                ans[prevIdx] = i - prevIdx;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {73,74,75,71,69,72,76,73};

        int[] ans = dailyTemperatures(arr);

        for (int i : ans) {
            System.out.println(i);
        }
    }
}