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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = mid(head);
        ListNode h = reverse(mid);
        while(head != null && h != null) {
            if(head.val != h.val) return false;
            head = head.next;
            h = h.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) next = next.next;
        }
        return prev;
    }
    public ListNode mid(ListNode head) {
        ListNode sp = head;
        ListNode fp = head;
        while(fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }
        return sp;
    }
}