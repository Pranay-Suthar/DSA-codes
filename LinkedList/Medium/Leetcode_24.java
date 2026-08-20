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
    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null) return head;

            ListNode dummy = new ListNode(0);

            dummy.next = head;

            ListNode beforeFirst = dummy;

            while (beforeFirst.next != null && beforeFirst.next.next != null) {

                ListNode first = beforeFirst.next;
                ListNode second = first.next;
                ListNode afterSecond = second.next;

                // Swaping the node
                first.next = afterSecond;
                second.next = first;
                beforeFirst.next = second;

                beforeFirst = first;
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
