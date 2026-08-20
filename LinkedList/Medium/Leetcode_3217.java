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
    public ListNode modifiedList(int[] nums, ListNode head) {

        ListNode dummy = new ListNode(0);
            dummy.next = head;

            int max = -1;

            for (int i : nums) {
                max = Math.max(max, i);
            }

            boolean[] freq = new boolean[max + 1];

            for (int i : nums) {
                freq[i] = true;
            }

             ListNode temp = dummy;

            int len = freq.length;

            while (head != null) {
                if (head.val >= len || freq[head.val] == false) {
                    temp.next = head;
                    temp = temp.next;
                }
                head = head.next;
            }

            temp.next = null;

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
