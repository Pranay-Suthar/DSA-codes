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
    public ListNode rotateRight(ListNode head, int k) {

        if (k == 0 || head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);

        ListNode tempHead = head;
        int count = 1;

        while(tempHead.next != null){
            count++;
            tempHead = tempHead.next;
        }

        k %= count;

        if (k == 0) return head;

        ListNode LStart = head;
        ListNode LEnd = head;

        for (int i = 1; i < count - k; i++) LEnd = LEnd.next;

        ListNode RStart = LEnd.next;
        ListNode REnd = tempHead;

        dummy.next = RStart;
        REnd.next = LStart;
        LEnd.next = null;

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
