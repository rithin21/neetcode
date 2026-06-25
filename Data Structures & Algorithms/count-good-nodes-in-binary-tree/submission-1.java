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
    public int goodNodes(TreeNode root) {
        int count=0;
        if(root==null)
        {
            return count;
        }
        Queue<TreeNode>q=new ArrayDeque<>();
        count=1;
        q.offer(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                if(curr.left!=null)
                {
                    if(curr.left.val<curr.val)
                    {
                        curr.left.val=curr.val;
                    }
                    else
                    {
                        count++;
                    }
                    q.offer(curr.left);
                }
                if(curr.right!=null)
                {
                    if(curr.right.val<curr.val)
                    {
                        curr.right.val=curr.val;
                    }
                    else
                    {
                        count++;
                    }
                    q.offer(curr.right);
                }
            }
        }
        return count;

        
    }
}
