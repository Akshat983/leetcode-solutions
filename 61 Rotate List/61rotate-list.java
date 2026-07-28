class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        int s = 0;
        ListNode t = head;
        ListNode last = null;
        while (t != null) {
            s++;
            if (t.next == null) last = t;
            t = t.next;
        }
        k = (k % s);
        if (k == 0) return head;
        t = head;
        ListNode newHeadPrev = null;
        for (int c = 0; c < s-k; c++) {
            newHeadPrev = t;
            t = t.next;
        }
        ListNode newHead = t;
        newHeadPrev.next = null;  
        last.next = head;       
        return newHead;
    }
}
