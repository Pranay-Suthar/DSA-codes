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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode beforeA = list1;
        ListNode afterB = list1;

        for(int i = 0; i < a - 1; i++) {
            beforeA = beforeA.next;
        }
                
        for (int i = 0; i < b + 1; i++) {
            afterB = afterB.next;
        }    
                
        beforeA.next = list2;

        while (beforeA.next != null) {
            beforeA = beforeA.next;
        }

        beforeA.next = afterB;

        return list1;
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
