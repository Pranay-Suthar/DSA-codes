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
    public ListNode[] splitListToParts(ListNode head, int k) {
            
        ListNode temp = head;
        int len = 0;

        ListNode[] list = new ListNode[k];
        
        while (temp != null) {
                len++;
                temp = temp.next;
        }

        int sizeOfSplit = len / k;
        int extra = len % k;
        temp = head;
        int idx  = 0;
        
        while (temp != null) {
            ListNode prevSplit = temp;
            int currSplitSize = sizeOfSplit + (extra > 0 ? 1 : 0);

            for(int i = 0; i < currSplitSize - 1; i++) {
                if (temp != null) {
                        temp = temp.next;
                }
            }
            ListNode nextSplit = temp.next;
            temp.next = null;
            list[idx++] = prevSplit;
            temp = nextSplit;

            if (extra > 0) extra--;
                
        }

        return list;
    
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
