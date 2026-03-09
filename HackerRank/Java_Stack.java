package HackerRank;

//Sample Input
//
//        {}()
//        ({()})
//        {}(
//        []
//
//Sample Output
//        true
//        true
//        true
//        false

import java.util.Scanner;
import java.util.Stack;

public class Java_Stack {

    public static boolean stack(String str){

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '{'|| ch == '[' || ch == '('){
                //push in stack
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                if (ch == '}'){
                    if (stack.peek() == '{'){
                        stack.pop();
                    } else {
                        return false;
                    }
                }

                else if (ch == ']'){
                    if (stack.peek() == '['){
                        stack.pop();
                    } else {
                        return false;
                    }
                }

                else if (ch == ')'){
                    if (stack.peek() == '('){
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }

        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();
            //Complete the code
            System.out.println(stack(input));
        }
    }
}
