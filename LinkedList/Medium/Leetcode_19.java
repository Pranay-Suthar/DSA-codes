package LinkedList.Medium;

public class Leetcode_19 {
    
}
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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null)
            return null;
        
        int count = 0;

        ListNode test = head;

        while(test != null){
            count++;
            test = test.next;
        }

        test = head;

        int diff = count - n;

        if(diff == 0) return head.next;

        for(int i = 0; i < diff - 1; i++){
            test = test.next;
        }

        test.next = test.next.next;

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
