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
    bool isBalanced(TreeNode* root) {
        if(root==NULL)
        {
            return true;
        }
        int left=maxheight(root->left);
        int right=maxheight(root->right);
        if(abs(left-right)>1)
        {
            return false;
        }

        return isBalanced(root->left)&&isBalanced(root->right);
        
    }

    int maxheight(TreeNode*root)
    {
        if(root==NULL)
        {
            return 0;
        }
        return 1+max(maxheight(root->left),maxheight(root->right));
    }
};
