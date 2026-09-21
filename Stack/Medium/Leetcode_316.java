import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_316 {

    public static String removeDuplicateLetters(String s) {
        int[] freq = new int[124]; // a -> 97 , z -> 122
        boolean[] visited = new boolean[124];
        char[] arr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : arr)
            freq[ch]++;


        for (char ch : arr) {
            freq[ch]--;

            if (visited[ch])
                continue;

            while (!stack.isEmpty() && stack.peek() > ch && freq[stack.peek()] > 0) {
                char popped = stack.pop();
                visited[popped] = false;
            }

            stack.push(ch);
            visited[ch] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "cbacdcbc";
        System.out.println(removeDuplicateLetters(str));
    }
}
