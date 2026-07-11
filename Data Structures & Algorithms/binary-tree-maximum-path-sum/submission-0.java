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

    int maxSum = Integer.MIN_VALUE;

    public int calc(TreeNode root) {

        // Base case
        if (root == null) {
            return 0;
        }

        // Best path coming from left subtree
        int left = Math.max(0, calc(root.left));

        // Best path coming from right subtree
        int right = Math.max(0, calc(root.right));

        // Best path that passes through this node
        int currentPath = left + right + root.val;

        // Update global maximum
        maxSum = Math.max(maxSum, currentPath);

        // Return the best single path to the parent
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {

        calc(root);

        return maxSum;
    }
}