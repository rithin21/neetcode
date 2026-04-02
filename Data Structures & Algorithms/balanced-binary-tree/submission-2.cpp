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
        if(check_height(root)!=-1)
        {
            return true;
        }
        return false;
    }

    int check_height(TreeNode*root)//use -1 as a signal
    {
        if(root==NULL)
        {
            return 0;
        }
        int left=check_height(root->left);
        if(left==-1)return -1;
        int right=check_height(root->right);
        if(right==-1)return -1;
        if(abs(left-right)>1)
        {
            return -1;
        }
        else
        {
            return max(left,right)+1;
        }
    }
};
