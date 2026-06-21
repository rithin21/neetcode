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
    public ListNode reverseList(ListNode head) {
        ListNode temp0=null;
        ListNode temp1=head;
        while(temp1!=null)
        {
            ListNode next=temp1.next;
            temp1.next=temp0;
            temp0=temp1;
            temp1=next;
        }
        return temp0;
        
    }
}
