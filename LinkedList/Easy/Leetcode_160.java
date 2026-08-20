/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null)
            return null;

        int countA = 0;
        int countB = 0;
        int diff = 0;

        ListNode tempA = headA;
        ListNode tempB = headB;


        while(tempA != null){
            countA++;
            tempA = tempA.next;
        }
        while(tempB != null){
            countB++;
            tempB = tempB.next;
        }

        if(countA > countB){
            diff = countA - countB;

            for(int i = 0; i < diff; i++)
                headA = headA.next;
            
        } else{
            diff = countB - countA;

            for(int i = 0; i < diff; i++)
                headB = headB.next;
        }



        // ListNode testB = headB;

        while(headA != null && headB != null){
            if(headA == headB) return headA;

            headA = headA.next;
            headB = headB.next;
        }

        return null;
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
