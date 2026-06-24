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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode>q=new ArrayDeque<>();
        List<List<Integer>>mainlist=new ArrayList<>();
        if(root==null)
        {
            return mainlist;
        }
        q.offer(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer>l=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                l.add(curr.val);
                if(curr.left!=null)
                {
                    q.offer(curr.left);
                }
                if(curr.right!=null)
                {
                    q.offer(curr.right);
                }
            }
            mainlist.add(l);
        }
        return mainlist;
        
    }
}
