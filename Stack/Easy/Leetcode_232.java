import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_232 {

    class MyQueue {
        private Deque<Integer> inStack;
        private Deque<Integer> outStack;

        public MyQueue() {
            inStack = new ArrayDeque<>();
            outStack = new ArrayDeque<>();
        }
        
        public void push(int x) {
            inStack.push(x);
        }
        
        public int pop() {
            moveElements();
            return outStack.pop();
        }
        
        public int peek() {
            moveElements();
            return outStack.peek();
        }
        
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void moveElements() {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }
    }
}
