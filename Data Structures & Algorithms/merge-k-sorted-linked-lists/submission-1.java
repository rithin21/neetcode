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

    class Node{
        int val;
        ListNode node;

        Node(int val,ListNode node){
            this.val=val;
            this.node=node;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Node>heap=new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode head=new ListNode();
        ListNode dummy=head;
        for(ListNode l:lists){
            if(l!=null){
                heap.offer(new Node(l.val,l));
            }
            
        }

        while(!heap.isEmpty()){
            Node x=heap.poll();
            dummy.next=x.node;
            dummy=dummy.next;
            if(x.node.next!=null){
                heap.offer(new Node(x.node.next.val,x.node.next));
            }
            
        }
        return head.next;
    }
}
