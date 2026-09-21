// Example 1:

//     Input: tokens = ["2","1","+","3","*"]
//     Output: 9
//     Explanation: ((2 + 1) * 3) = 9

// Example 2:

//     Input: tokens = ["4","13","5","/","+"]
//     Output: 6
//     Explanation: (4 + (13 / 5)) = 6

// Example 3:

//     Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//     Output: 22
//     Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//     = ((10 * (6 / (12 * -11))) + 17) + 5
//     = ((10 * (6 / -132)) + 17) + 5
//     = ((10 * 0) + 17) + 5
//     = (0 + 17) + 5
//     = 17 + 5
//     = 22

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_150 {

    public static int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (String str : tokens) {
            switch (str) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 - num1);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" ->  {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(num2 / num1);
                }
                default -> stack.push(Integer.parseInt(str));
            }
            // System.out.println(stack);
        }
        return stack.peek();
    }

    public static void main(String[] args) {

        String[] arr ={"129","-195","122","+","/","-177","+","115","-"};//-293

        System.out.println(evalRPN(arr));
    }
}
