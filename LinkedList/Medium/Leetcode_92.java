/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

            if (head == null || head.next == null || left == right) return head;

            ListNode dummy = new ListNode(0);
            dummy.next = head;


            ListNode temp = dummy;
            ListNode beforeLeft = temp;

            ListNode RightNode = temp;
            ListNode LeftNode = temp;


            for (int i = 1; i < left; i++) {
                temp = temp.next;
            }
            beforeLeft = temp;
            LeftNode = temp.next;


            RightNode = LeftNode;

            for (int i = left; i < right; i++) {
                RightNode = RightNode.next;
            }

            ListNode afterRight = RightNode.next;
            ListNode curr = LeftNode;
            ListNode prev = null;

            while (curr != afterRight) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            beforeLeft.next = prev;
            LeftNode.next = afterRight;

            return dummy.next;
        }


    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
