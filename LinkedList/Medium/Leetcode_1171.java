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
    public ListNode removeZeroSumSublists(ListNode head) {

        if (head.next == null && head.val == 0) return null;

        if(head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> map = new HashMap<>();

        ListNode temp = dummy;

        int sum = 0;

        while (temp != null) {
            sum += temp.val;
            if (map.containsKey(sum)) {

                ListNode node = map.get(sum);

                int currentSum = sum + node.next.val;
                ListNode curr = node.next;
                while (curr != temp) {
                    map.remove(currentSum);
                    currentSum += curr.next != null ? curr.next.val : 0;
                    curr = curr.next;
                }
                
                node.next = temp.next;
                temp = node.next;
            } else{
                map.put(sum, temp);
                temp = temp.next;
            }
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
