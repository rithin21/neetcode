class Solution {
    public void reorderList(ListNode head) {

        if(head == null || head.next == null)
            return;

        // Find middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode second = slow.next;
        slow.next = null;

        ListNode prev = null;

        while(second != null)
        {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        // Merge
        ListNode first = head;
        ListNode secondHalf = prev;

        while(secondHalf != null)
        {
            ListNode t1 = first.next;
            ListNode t2 = secondHalf.next;

            first.next = secondHalf;
            secondHalf.next = t1;

            first = t1;
            secondHalf = t2;
        }
    }
}