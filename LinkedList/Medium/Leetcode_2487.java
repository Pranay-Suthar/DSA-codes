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

    public ListNode removeNodes(ListNode head) {

        head = revers(head);

            ListNode temp = head;
            
            int max = -1;
            ListNode dummy = new ListNode(0);
            ListNode tempDummy = dummy;
            
            while (temp != null) {
                if (temp.val >= max) {
                    ListNode newHead = temp.next;

                    max = temp.val;

                    tempDummy.next = temp;
                    tempDummy = tempDummy.next;
                    tempDummy.next = null;

                    temp = newHead;
                    
                } else{
                    temp = temp.next;
                }
            }

            return revers(dummy.next);
        
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
