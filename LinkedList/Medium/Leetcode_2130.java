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

    public ListNode revers(ListNode head) {
            ListNode prev = null;

            while (head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }

            return prev;
        }

    public int pairSum(ListNode head) {

        ListNode slow = head;
        ListNode beforeSlow = null;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
                beforeSlow = slow;
                slow = slow.next;
                fast = fast.next.next;
        }

        ListNode otherHalf = revers(beforeSlow.next);

        int max = -1;
                    
        while (otherHalf != null) {
                max = Math.max(head.val + otherHalf.val, max);
                head = head.next;
                otherHalf = otherHalf.next;
        }

        return max;
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
