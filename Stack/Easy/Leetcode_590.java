import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Leetcode_590 {
    

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> res = new ArrayList<>();
            
            if (root == null)
                return res;

            Deque<Node> stack = new ArrayDeque<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                Node curr = stack.pop();
                res.add(curr.val);

                if (curr.children != null) {
                    for (Node child : curr.children) {
                        stack.push(child);
                    }
                }
            }

            Collections.reverse(res);
            return res;
        }
    }
}
