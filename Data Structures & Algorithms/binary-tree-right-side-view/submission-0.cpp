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
    void dfs(TreeNode*root,int level,vector<int>&result,vector<bool>&filled)
    {
        if(root==NULL)
        {
            return;
        }
        if(filled[level]==false)
        {
            result.push_back(root->val);
            filled[level]=true;
        }
        dfs(root->right,level+1,result,filled);
        dfs(root->left,level+1,result,filled); 
    }

    int find_height(TreeNode*root)
    {
        if(root==NULL)
        {
            return 0;
        }
        return max(find_height(root->right),find_height(root->left))+1;
    }

    vector<int> rightSideView(TreeNode* root) {
        //find height of a tree,n
        int n=find_height(root);
        vector<int>result;
        vector<bool>filled(n,false);
        dfs(root,0,result,filled);
        return result;
    }
};
