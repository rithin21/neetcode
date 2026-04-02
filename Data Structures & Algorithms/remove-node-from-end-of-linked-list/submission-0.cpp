/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        vector<ListNode*>nodes;
        ListNode*curr=head;
        while(curr!=NULL)
        {
            nodes.push_back(curr);
            curr=curr->next;
        }

        int removeindex=nodes.size()-n;
        if(removeindex==0)
        {
            return head->next;
        }
        nodes[removeindex-1]->next=nodes[removeindex]->next;
        return head;
        
    }
};
