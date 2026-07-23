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
        ListNode node = head;
        ListNode prevOfLastNth = head;

        for(int i = 0; i <= n; i++) {
            if(node == null) {
                return head.next;
            }
            node = node.next;
        }

        while(node != null) {
            node = node.next;
            prevOfLastNth = prevOfLastNth.next;
        }
        prevOfLastNth.next = prevOfLastNth.next.next;
        return head;
    }
}