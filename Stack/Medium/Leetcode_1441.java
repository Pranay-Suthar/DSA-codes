

// Example 1:

//     Input: target = [1,3], n = 3
//     Output: ["Push","Push","Pop","Push"]
//     Explanation: Initially the stack s is empty. The last element is the top of the stack.
//     Read 1 from the stream and push it to the stack. s = [1].
//     Read 2 from the stream and push it to the stack. s = [1,2].
//     Pop the integer on the top of the stack. s = [1].
//     Read 3 from the stream and push it to the stack. s = [1,3].

// Example 2:

//     Input: target = [1,2,3], n = 3
//     Output: ["Push","Push","Push"]
//     Explanation: Initially the stack s is empty. The last element is the top of the stack.
//     Read 1 from the stream and push it to the stack. s = [1].
//     Read 2 from the stream and push it to the stack. s = [1,2].
//     Read 3 from the stream and push it to the stack. s = [1,2,3].

// Example 3:

//     Input: target = [1,2], n = 4
//     Output: ["Push","Push"]
//     Explanation: Initially the stack s is empty. The last element is the top of the stack.
//     Read 1 from the stream and push it to the stack. s = [1].
//     Read 2 from the stream and push it to the stack. s = [1,2].
//     Since the stack (from the bottom to the top) is equal to target, we stop the stack operations.
//     The answers that read integer 3 from the stream are not accepted.

import java.util.ArrayList;
import java.util.List;

public class Leetcode_1441 {
    
    public static List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int idx = 0;

        for (int i = 1; i <= n && idx < target.length; i++) {
            result.add("Push");

            if (target[idx] == i) {
                idx++;
            } else {
                result.add("Pop");
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] target = {1,2};
        int n = 4;

        System.out.println(buildArray(target, n));
    }
}
