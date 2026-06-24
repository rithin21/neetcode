/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    class Info{
        int height;
        boolean balanced;

        Info(int height,boolean balanced)
        {
            this.height=height;
            this.balanced=balanced;
        }
    }

    public Info dfs(TreeNode root)
    {
        if(root==null)
        {
            return new Info(0,true);
        }
        Info left=dfs(root.left);
        Info right=dfs(root.right);

        int height=1+Math.max(left.height,right.height);
        boolean balanced=left.balanced&&right.balanced&&(Math.abs(left.height-right.height)<=1);
        return new Info(height,balanced);
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root).balanced;

        
        
    }
}
