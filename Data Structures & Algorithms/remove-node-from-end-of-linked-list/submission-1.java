class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int count = 0;
        ListNode temp = head;

        while(temp != null) {
            count++;
            temp = temp.next;
        }

        if(count == n)
            return head.next;

        int target = count - n - 1;

        ListNode prev = head;

        while(target > 0) {
            prev = prev.next;
            target--;
        }

        prev.next = prev.next.next;

        return head;
    }
}