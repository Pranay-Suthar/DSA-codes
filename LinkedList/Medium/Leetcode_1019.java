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
                public int nextMax(ListNode head){
                        if (head == null) {
                                return 0;
                        }

                        ListNode temp = head.next;

                        while (temp != null) {
                                if (temp.val > head.val) {
                                        return temp.val;
                                } else if (temp.val == head.val){
                                        return nextMax(temp);
                                }
                                else{
                                        temp = temp.next;
                                }
                        }
                        return 0;
                }

                public int[] nextLargerNodes(ListNode head) {

                        List<Integer> list = new ArrayList<>();

                        while (head != null) {
                                int max = nextMax(head);
                                list.add(max);
                                head = head.next;
                        }

                        return list.stream().mapToInt(Integer::intValue).toArray();
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
