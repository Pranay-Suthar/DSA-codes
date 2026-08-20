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
    public ListNode doubleIt(ListNode head) {

        // If the first digit becomes >= 10, we need a new head.
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // We'll build the answer as we traverse.
        ListNode temp = dummy;

        while (head != null) {

            int sum = head.val * 2;
            int carry = sum / 10;

            // Carry always belongs to the previous digit,
            // so update the last node we already created.
            if (carry != 0)
                temp.val += carry;

            // Current digit after doubling.
            temp.next = new ListNode(sum % 10);

            temp = temp.next;
            head = head.next;
        }

        // If the dummy was never used, skip it.
        return dummy.val == 0 ? dummy.next : dummy;

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
