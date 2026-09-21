import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode_682
 */

// Example 1:

//     Input: ops = ["5","2","C","D","+"]
//     Output: 30
//     Explanation:
//     "5" - Add 5 to the record, record is now [5].
//     "2" - Add 2 to the record, record is now [5, 2].
//     "C" - Invalidate and remove the previous score, record is now [5].
//     "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
//     "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
//     The total sum is 5 + 10 + 15 = 30.

//     Example 2:

//     Input: ops = ["5","-2","4","C","D","9","+","+"]
//     Output: 27
//     Explanation:
//     "5" - Add 5 to the record, record is now [5].
//     "-2" - Add -2 to the record, record is now [5, -2].
//     "4" - Add 4 to the record, record is now [5, -2, 4].
//     "C" - Invalidate and remove the previous score, record is now [5, -2].
//     "D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
//     "9" - Add 9 to the record, record is now [5, -2, -4, 9].
//     "+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
//     "+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
//     The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.

public class Leetcode_682 {

    public static int calPoints(String[] opr) {//52CD+
        int ans = 0;
        var stack = new ArrayDeque<Integer>();
        
        for (int i = 0; i < opr.length; i++) {
            // if(opr[i].equals("C"))
            //     stack.pop();
            // else if(opr[i].equals("D"))
            //     stack.push(stack.peek() * 2);
            // else if(opr[i].equals("+")){
            //     int first = stack.pop();
            //     int second = stack.peek();
            //     stack.push(first);
            //     stack.push(first + second);
            // }
            // else
            //     stack.push(Integer.parseInt(opr[i]));
            switch (opr[i]) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "+":
                    int first = stack.pop();
                    int second = stack.peek();
                    stack.push(first);
                    stack.push(first + second);
                    break;
            
                default:
                    stack.push(Integer.parseInt(opr[i]));
                    break;
            }
        }
        for (int num : stack)
            ans += num;

        return ans;
    }

    public static void main(String[] args) {
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(ops));
    }
}