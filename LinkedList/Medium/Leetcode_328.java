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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddList = new ListNode(0);
        ListNode evenList = new ListNode(0);
        ListNode tempOdd = oddList;
        ListNode tempEven = evenList;

        while (head != null && head.next != null) {

            ListNode newHead = head.next;

            tempOdd.next = head;
            tempOdd = tempOdd.next;
            tempOdd.next = null;

            head = newHead;
            newHead = head.next;

            tempEven.next = head;
            tempEven = tempEven.next;
            tempEven.next = null;

            head = newHead;
        }

        if (head != null) {
            tempOdd.next = head;
            tempOdd = tempOdd.next;
            tempOdd.next = null;
        }

        tempOdd.next = evenList.next;

        return oddList.next;
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
