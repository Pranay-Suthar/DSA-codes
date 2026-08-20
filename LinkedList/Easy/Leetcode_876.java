class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 0;

        ListNode curr = head;

        while(curr != null){
            count++;
            curr = curr.next;
        }

        for(int i = 0; i < (count/2);i++){
            head = head.next;
        }
    
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
