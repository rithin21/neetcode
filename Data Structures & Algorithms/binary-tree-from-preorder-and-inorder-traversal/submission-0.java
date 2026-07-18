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
    int preorder_index=0;
    HashMap<Integer,Integer>map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map=new HashMap<>();
        
        for(int i=0;i<preorder.length;i++){
            map.put(inorder[i],i);
        }

        return buildactualtree(preorder,inorder,0,preorder.length-1);


    }

    public TreeNode buildactualtree(int[]preorder,int[]inorder,int left,int right){
        if(left>right){
            return null;
        }
        int mid=map.get(preorder[preorder_index++]);
        TreeNode root=new TreeNode(inorder[mid]);
        root.left=buildactualtree(preorder,inorder,left,mid-1);
        root.right=buildactualtree(preorder,inorder,mid+1,right);
        return root;
    }
}
