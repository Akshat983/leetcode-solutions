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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) return head;

        ListNode prev = null; 
        ListNode curr = head;
        int c = 0;

        while(curr != null) {
            c++;
            curr = curr.next;
        }
        curr = head;

        for(int l = 0; l < (int)c/k; l++) {
            ListNode next = curr.next;
            ListNode last = prev;
            ListNode currEnd = curr;
            for(int i = 0; curr != null && i < k; i++) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if(next != null) next = curr.next;
            }
            if(last == null) head = prev;
            else {
                last.next = prev;
            }
            currEnd.next = curr;
            prev = currEnd;
        }

        return head;
    }
}