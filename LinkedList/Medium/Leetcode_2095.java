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
    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode beforeSlow = null;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            beforeSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        beforeSlow.next = beforeSlow.next.next;
        
        return head;
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
