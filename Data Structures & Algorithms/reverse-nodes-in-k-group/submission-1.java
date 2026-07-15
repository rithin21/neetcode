/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; }
 * }
 */

class Solution {

    class Result {
        ListNode head;
        ListNode tail;
    }

    Result findInterval(ListNode head, int k) {

        if (head == null)
            return null;

        Result res = new Result();
        res.head = head;

        for (int i = 1; i < k; i++) {
            head = head.next;

            if (head == null)
                return null;
        }

        res.tail = head;
        return res;
    }

    Result reverse(Result res) {

        Result rev = new Result();

        ListNode stop = res.tail.next;

        ListNode prev = stop;
        ListNode curr = res.head;

        while (curr != stop) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        rev.head = res.tail;
        rev.tail = res.head;

        return rev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1)
            return head;

        ListNode curr = head;

        ListNode prevTail = null;

        ListNode newHead = head;

        while (true) {

            Result group = findInterval(curr, k);

            if (group == null)
                break;

            // Save next group BEFORE reversing
            ListNode nextGroup = group.tail.next;

            Result rev = reverse(group);

            if (prevTail == null)
                newHead = rev.head;
            else
                prevTail.next = rev.head;

            prevTail = rev.tail;

            curr = nextGroup;
        }

        return newHead;
    }
}