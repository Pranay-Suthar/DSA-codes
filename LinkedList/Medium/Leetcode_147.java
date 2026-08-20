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
    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = dummy;
        ListNode tail = head;
        ListNode curr = tail.next;

        while (curr != null) {
            ListNode otherList = curr.next;

            if (curr.val <= head.val) {
                curr.next = null;
                temp.next = curr;
                curr.next = head;
                head = temp.next;
                tail.next = otherList;
            }
            else if (curr.val >= tail.val) {
                tail = tail.next;
            } else {
                ListNode travers = dummy;
                tail.next = otherList;
                curr.next = null;
                
                while (curr.val >= travers.next.val) {
                    travers = travers.next;
                }
                ListNode nextList = travers.next;
                travers.next = curr;
                curr.next = nextList;
            }
            curr = tail.next;
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
