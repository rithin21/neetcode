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
    int maxDepth(TreeNode* root) {
        queue<TreeNode*>q;
        int level=0;
        if(root!=NULL)
        {
            q.push(root);
        }
        while(q.empty()==0)
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode* front=q.front();
                q.pop();
                if(front->left)
                {
                    q.push(front->left);
                }
                if(front->right)
                {
                    q.push(front->right);
                }
            }
            level++;
            
        }
        return level;
        
    }
};
