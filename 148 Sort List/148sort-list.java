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
    public ListNode sortList(ListNode head) {
        return mergesort(head);
    }

    private ListNode mergesort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode midPrev = findMid(head);
        ListNode right = midPrev.next;
        midPrev.next = null;

        ListNode left = mergesort(head);
        right = mergesort(right);

        return merge(left, right);
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev; 
    }

    private ListNode merge(ListNode f, ListNode s) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (f != null && s != null) {
            if (f.val < s.val) {
                tail.next = f;
                f = f.next;
            } else {
                tail.next = s;
                s = s.next;
            }
            tail = tail.next;
        }

        if (f != null) tail.next = f;
        if (s != null) tail.next = s;

        return dummy.next;
    }
}