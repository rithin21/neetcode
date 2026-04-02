/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        vector<int>elements;
        queue<TreeNode*>q;
        q.push(root);
        elements.push_back(root->val);
        while(q.empty()==false)
        {
            TreeNode*u=q.front();
            q.pop();
            if(u->left)
            {
                elements.push_back(u->left->val);
                q.push(u->left);
            }
            if(u->right)
            {
                elements.push_back(u->right->val);
                q.push(u->right);
            }
        }
        sort(elements.begin(),elements.end());
        for(int i=0;i<k;i++)
        {
            if(i==k-1)
            {
                return elements[i];
            }
        }
        
    }
};
