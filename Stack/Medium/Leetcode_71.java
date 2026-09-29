


// Example 1:

//     Input: path = "/home/"
//     Output: "/home"
//     Explanation:
//     The trailing slash should be removed.

// Example 2:

//     Input: path = "/home//foo/"
//     Output: "/home/foo"
//     Explanation:
//     Multiple consecutive slashes are replaced by a single one.

// Example 3:

//     Input: path = "/home/user/Documents/../Pictures"
//     Output: "/home/user/Pictures"
//     Explanation:
//     A double period ".." refers to the directory up a level (the parent directory).

// Example 4:

//     Input: path = "/../"
//     Output: "/"
//     Explanation:
//     Going one level up from the root directory is not possible.

// Example 5:

//     Input: path = "/.../a/../b/c/../d/./"
//     Output: "/.../b/d"
//     Explanation:
//     "..." is a valid name for a directory in this problem.

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_71 {
    
    public static String simplifyPath(String path) {
        String[] str = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (String s : str) {
            if (s.equals("") || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }

        // System.out.println(stack);
        StringBuilder sb = new StringBuilder();

        if (stack.isEmpty()) {
            return "/";
        }

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String str = "/home/user/Documents/../Pictures";
        //Output : "/home/user/Pictures"

        System.out.println(simplifyPath(str));
    }
}
