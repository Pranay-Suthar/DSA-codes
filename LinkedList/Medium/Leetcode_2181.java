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
    public ListNode mergeNodes(ListNode head) {
        ListNode firstZero = head;
        
        while (firstZero.next != null) {
            ListNode secondZero = firstZero.next;
            int sum = 0;
            while (secondZero.val != 0) {
                sum += secondZero.val;
                secondZero = secondZero.next;
            }
            firstZero.val = sum;
            firstZero.next = secondZero.next == null ? null : secondZero;
            firstZero = secondZero;
        }

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
