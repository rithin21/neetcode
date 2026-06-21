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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1=list1;
        ListNode head2=list2;
        ListNode finalhead=new ListNode();
        ListNode currhead=finalhead;

        while(head1!=null && head2!=null)
        {
            if(head1.val<head2.val)
            {
                currhead.next=new ListNode(head1.val);
                head1=head1.next;
            }
            else
            {
                currhead.next=new ListNode(head2.val);
                head2=head2.next;
            }
            currhead=currhead.next;
        }

        while(head1!=null)
        {
            currhead.next=new ListNode(head1.val);
            currhead=currhead.next;
            head1=head1.next;
        }

        while(head2!=null)
        {
            currhead.next=new ListNode(head2.val);
            currhead=currhead.next;
            head2=head2.next;
        }
        return finalhead.next;
        
    }
}