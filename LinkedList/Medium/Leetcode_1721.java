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
    public ListNode swapNodes(ListNode head, int k) {

        if(head.next == null) return head;

            ListNode tempHead = head;

            for(int i = 1; i < k; i++) tempHead = tempHead.next;
            
            ListNode first = tempHead;
            ListNode second = head;

            while(tempHead.next != null){
                second = second.next;
                tempHead = tempHead.next;
            }

            int temp = first.val;
            first.val = second.val;
            second.val = temp;

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
