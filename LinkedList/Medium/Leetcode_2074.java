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

    public ListNode reverseBetween(ListNode head, ListNode end) {
        ListNode prev = null;
        while (head != end) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroEnd = dummy;
        ListNode curr = dummy.next;
        int size = 1;

        while (curr != null) {
            int count = 0;
            ListNode GStart = curr;
            ListNode temp = curr;

            for(int i = 0; i < size && temp != null; i++) {
                temp = temp.next;
                count++;
            }

            if (count % 2 == 0) {
                ListNode reverseHead = reverseBetween(GStart, temp);
                prevGroEnd.next = reverseHead;
                GStart.next = temp;
                prevGroEnd = GStart;
                curr = temp;
            } else {
                for(int i = 0; i < count; i++) {
                    prevGroEnd = curr;
                    curr = curr.next;
                }
            }
            size++;
        }

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
