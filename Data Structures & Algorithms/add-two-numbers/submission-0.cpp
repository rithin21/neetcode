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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
       int x,y,carry;
       carry=0;
       ListNode*curl1=l1;
       ListNode*curl2=l2;
       ListNode*result=new ListNode();
       ListNode*dummy=result;
       while(curl1!=NULL||curl2!=NULL||carry!=0)
       {
        if(curl1==NULL)
        {
            x=0;
        }
        else
        {
            x=curl1->val;
        }

        if(curl2==NULL)
        {
            y=0;
        }
        else
        {
            y=curl2->val;
        }

        int sum=x+y+carry;
        carry=sum/10;
        int digit=sum%10;

        dummy->val=digit;

        if(curl1!=NULL)
        {
            curl1=curl1->next;
        }
        if(curl2!=NULL)
        {
            curl2=curl2->next;
        }

        if(curl1!=NULL||curl2!=NULL||carry!=0)
        {
            dummy->next=new ListNode();
            dummy=dummy->next;
        }
       }
       return result;
    }

};


