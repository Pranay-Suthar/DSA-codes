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
    public ListNode partition(ListNode head, int x) {

            ListNode lessDummy = new ListNode(0);
            ListNode greterDummy = new ListNode(0);

            ListNode less = lessDummy;
            ListNode greter = greterDummy;

            while (head != null) {

                ListNode nextHead = head.next;
                head.next = null;
                
                if (head.val < x) {
                    less.next = head;
                    less = less.next;
                } else{
                    greter.next = head;
                    greter = greter.next;
                }
                head = nextHead;
            }

            less.next = greterDummy.next;
                
            return lessDummy.next;
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
