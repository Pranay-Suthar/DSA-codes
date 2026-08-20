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
        public ListNode reverseKGroup(ListNode head, int k) {

            if (head == null || head.next == null || k == 1) return head;

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode beforeFirst = dummy;

            
            while (true) {

                ListNode tempH = beforeFirst;
                for (int i = 0; i < k && tempH != null; i++) {
                    tempH = tempH.next;
                }

                if (tempH == null)
                    break;

                ListNode second = tempH;
                ListNode afterSecond = second.next;

                ListNode first = beforeFirst.next;

                ListNode prev = afterSecond;
                ListNode curr = first;

                while (curr != afterSecond) {
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }

                ListNode temp = beforeFirst.next;
                beforeFirst.next = second;
                beforeFirst = temp;
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
