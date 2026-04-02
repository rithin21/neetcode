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
    int diameterOfBinaryTree(TreeNode* root) {
        if(root==NULL)
        {
            return 0;
        }
        int leftheight=maxheight(root->left);
        int rightheight=maxheight(root->right);
        int diameter=leftheight+rightheight;
        int sub=max(diameterOfBinaryTree(root->left),diameterOfBinaryTree(root->right));
        return max(diameter,sub);
        
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
